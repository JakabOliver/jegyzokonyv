package hu.bme.aut.jegyzokonyv;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import hu.bme.aut.jegyzokonyv.data.DataManager;
import hu.bme.aut.jegyzokonyv.data.Match;
import hu.bme.aut.jegyzokonyv.data.Player;
import hu.bme.aut.jegyzokonyv.data.Team;

public class GameActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        DataManager dtm = DataManager.getInstance();
        loadPlayers(dtm);

    }

    private void loadPlayers(DataManager dtm) {
        Match match = dtm.getMatch();
        Team home = match.getHome();
        TextView tw = findViewById(R.id.textView1);
        tw.setText(home.getPlayers()[0].getName());
        for (int i = 0; i < 8; i++) {
            String buttonId = "textView" + (i + 1);
            int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
            TextView twi = findViewById(resId);
            Player player = home.getPlayers()[i];
            twi.setText(player.getName() + " #" + player.getNumber());
        }
    }

}
