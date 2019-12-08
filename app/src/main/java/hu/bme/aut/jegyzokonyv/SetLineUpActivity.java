package hu.bme.aut.jegyzokonyv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import hu.bme.aut.jegyzokonyv.adapter.PlayerRecylerAdapter;
import hu.bme.aut.jegyzokonyv.data.DataManager;
import hu.bme.aut.jegyzokonyv.data.Team;

public class SetLineUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DataManager dtm = DataManager.getInstance();
        Intent intent = getIntent();
        String t = intent.getStringExtra("team");
        Team team;
        assert t != null;
        if (t.equals("home")) {
            team = dtm.getMatch().getHome();
        } else {
            team = dtm.getMatch().getAway();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_lineup);

        final RecyclerView recyclerView = findViewById(R.id.recylerView);

        TextView teamTV = findViewById(R.id.lineupTeamTextView);
        teamTV.setText(team.getName());

        PlayerRecylerAdapter playerRecylerAdapter = new PlayerRecylerAdapter(team.getPlayers());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(playerRecylerAdapter);
        Button btnSave = findViewById(R.id.saveButton);
        btnSave.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
    }
}
