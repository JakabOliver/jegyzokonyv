package hu.bme.aut.jegyzokonyv;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

import hu.bme.aut.jegyzokonyv.data.DataManager;
import hu.bme.aut.jegyzokonyv.data.Goal;
import hu.bme.aut.jegyzokonyv.data.Match;
import hu.bme.aut.jegyzokonyv.data.Player;
import hu.bme.aut.jegyzokonyv.data.Team;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    final int LENGTH_OF_GAME = 10 * 60 * 1000;
    final int MAX_GAME_PART = 4;
    //final int LENGTH_OF_GAME = 5 * 1000;
    //final int MAX_GAME_PART = 2;

    CountDownTimer timer;
    DataManager dtm;
    long millisecLeft = LENGTH_OF_GAME;
    boolean clockIsRunning = false;
    Button startStopButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        dtm = DataManager.getInstance();
        loadPlayers();
        displayScore();
        dtm.getMatch().setPart(1);
        resetTimer();
        startStopButton = findViewById(R.id.startstopButton);
        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clockIsRunning) {
                    resetTimer();
                    timer.start();
                    clockIsRunning = true;
                    startStopButton.setText(getResources().getString(R.string.pause));
                } else {
                    timer.cancel();
                    clockIsRunning = false;
                    startStopButton.setText(getResources().getString(R.string.continue2));
                }
            }
        });

    }


    private void loadPlayers() {
        Match match = dtm.getMatch();
        Team home = match.getHome();
        Team away = match.getAway();
        for (int i = 0; i < 4; i++) {
            Team team = i < 2 ? home : away;
            char t = i < 2 ? '1' : '2';
            Player[] players;
            char a;
            if (i % 2 == 0) {
                players = team.getAttackers();
                a = 'A';
            } else {
                players = team.getDeffenders();
                a = 'D';
            }
            for (int j = 0; j < 4; j++) {
                setPlayer(players[j], (i * 4) + j, String.valueOf(t) + String.valueOf(a) + String.valueOf((j + 1)));
            }
        }


    }

    private void setPlayer(Player player, int i, String pos) {
        String textViewID = "textView" + pos;
        //textView1A1
        String buttonId = "imageButton" + (i + 1);
        int twID = getResources().getIdentifier(textViewID, "id", getPackageName());
        int BtnId = getResources().getIdentifier(buttonId, "id", getPackageName());
        TextView twi = findViewById(twID);

        player.setButtonId(BtnId);
        twi.setText(String.format(Locale.ENGLISH, "%s #%d", player.getName(), player.getNumber()));
        findViewById(BtnId).setOnClickListener(this);
    }

    @Override
    public void onClick(@NotNull View v) {
        Match match = dtm.getMatch();
        Player player = match.getPlayerByButtonId(v.getId());
        registerGoal(player, v);

    }

    private void registerGoal(@NotNull Player player, View v) {
        Match match = dtm.getMatch();
        Team team;
        if (match.getHome().getId() == player.getTeam_id()) {
            match.homeTeamScored();
            team = match.getHome();
        } else {
            match.awayTeamScored();
            team = match.getAway();
        }
        long time = (dtm.getMatch().getPart() - 1) * (LENGTH_OF_GAME / 1000) + (LENGTH_OF_GAME - this.millisecLeft) / 1000;
        new Goal(player, team, dtm.getMatch(), time).save();
        displayScore();
        Toast.makeText(v.getContext(), String.format(Locale.ENGLISH, getResources().getString(R.string.scored), player.getName(), player.getNumber()),
                Toast.LENGTH_SHORT).show();
    }

    private void displayScore() {
        Match match = dtm.getMatch();
        TextView twi = findViewById(R.id.scoreTextView);
        twi.setText(String.format(Locale.ENGLISH, "%s - %s", match.getHomePoint(), match.getAwayPoint()));
    }

    private void displayTime(long millisUntilFinished) {
        TextView tv = findViewById(R.id.timeTextView);
        int second = (int) millisUntilFinished / 1000;
        int minute = second / 60;
        second -= (minute * 60);

        tv.setText(String.format(Locale.ENGLISH, "%d:%d", minute, second));
    }

    private void resetTimer() {


        int millisec = LENGTH_OF_GAME;
        if (millisecLeft != 0) {
            millisec = (int) millisecLeft;
        }

        displayTime((long) millisec);
        timer = new CountDownTimer(millisec, 1000) {

            public void onTick(long millisUntilFinished) {
                millisecLeft = millisUntilFinished;
                displayTime(millisUntilFinished);
            }

            public void onFinish() {
                timer.cancel();
                clockIsRunning = false;
                startStopButton.setText(getResources().getString(R.string.start));
                millisecLeft = LENGTH_OF_GAME;
                if (dtm.getMatch().getPart() < MAX_GAME_PART) {
                    dtm.getMatch().startNextPart();
                    resetTimer();
                } else {
                    dtm.getMatch().save();
                    gameOver();
                }
            }
        };
        TextView gamePart = findViewById(R.id.gamePart);
        gamePart.setText(String.valueOf(dtm.getMatch().getPart()));
    }


    private void gameOver() {
        Intent resultIntent = new Intent(GameActivity.this, ResultActivity.class);
        startActivity(resultIntent);
    }
}
