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
        DataManager dtm = DataManager.getInstance();
        loadPlayers(dtm);
        for (int i = 0; i < 8; i++) {
            String buttonId = "imageButton" + (i + 1);
            int BtnId = getResources().getIdentifier(buttonId, "id", getPackageName());
            findViewById(BtnId).setOnClickListener(this);
        }


    }

    private void loadPlayers(DataManager dtm) {
        Match match = dtm.getMatch();
        Team home = match.getHome();
        for (int i = 0; i < 8; i++) {
            String textViewID = "textView" + (i + 1);
            String buttonId = "imageButton" + (i + 1);
            int twID = getResources().getIdentifier(textViewID, "id", getPackageName());
            int BtnId = getResources().getIdentifier(buttonId, "id", getPackageName());
            TextView twi = findViewById(twID);
            Player player = home.getPlayers()[i];
            player.setButtonId(BtnId);
            twi.setText(player.getName() + " #" + player.getNumber());
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
    }

}
