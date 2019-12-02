package hu.bme.aut.jegyzokonyv;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import hu.bme.aut.jegyzokonyv.data.DataManager;
import hu.bme.aut.jegyzokonyv.data.Match;
import hu.bme.aut.jegyzokonyv.data.Player;
import hu.bme.aut.jegyzokonyv.data.Team;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        dtm = DataManager.getInstance();
        loadPlayers();
        displayScore();
        resetTimer();
        startStopButton = findViewById(R.id.startstopButton);
        startStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!clockIsRunning) {
                    resetTimer();
                    timer.start();
                    clockIsRunning = true;
                    startStopButton.setText("Pause");
                } else {
                    timer.cancel();
                    clockIsRunning = false;
                    startStopButton.setText("Continue");
                }
            }
        });

    }


    private void loadPlayers() {
        Match match = dtm.getMatch();
        Team home = match.getHome();
        Team away = match.getAway();
        Player player;
        for (int i = 0; i < 16; i++) {
            String textViewID = "textView" + (i + 1);
            String buttonId = "imageButton" + (i + 1);
            int twID = getResources().getIdentifier(textViewID, "id", getPackageName());
            int BtnId = getResources().getIdentifier(buttonId, "id", getPackageName());
            TextView twi = findViewById(twID);
            if (i < 8) {
                player = home.getPlayers()[i];
            } else {
                player = away.getPlayers()[(i - 8)];
            }
            player.setButtonId(BtnId);
            twi.setText(player.getName() + " #" + player.getNumber());
            findViewById(BtnId).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        DataManager dtm = DataManager.getInstance();
        Match match = dtm.getMatch();
        Player player = match.getPlayerByButtonId(v.getId());
        registerGoal(player, v);

    }

    private void registerGoal(Player player, View v) {
        Toast.makeText(v.getContext(), "Gólt dobott: " + player.getName() + " #" + player.getNumber(),
                Toast.LENGTH_SHORT).show();
        Match match = dtm.getMatch();
        if (match.getHome().getId() == player.getTeam()) {
            match.homeTeamScored();
        } else {
            match.awayTeamScored();
        }
        displayScore();
    }

    private void displayScore() {
        Match match = dtm.getMatch();
        TextView twi = findViewById(R.id.scoreTextView);
        twi.setText(match.getHomePoint() + "-" + match.getAwayPoint());
    }

}
