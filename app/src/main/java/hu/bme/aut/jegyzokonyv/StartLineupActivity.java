package hu.bme.aut.jegyzokonyv;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import hu.bme.aut.jegyzokonyv.adapter.RecylerAdapter;
import hu.bme.aut.jegyzokonyv.data.DataManager;

public class StartLineupActivity extends AppCompatActivity {

    private RecylerAdapter recylerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_lineup);

        final RecyclerView recyclerView = findViewById(R.id.recylerView);
        DataManager dtm = DataManager.getInstance();
        TextView teamTV = findViewById(R.id.lineupTeamTextView);
        teamTV.setText(dtm.getMatch().getHome().getName());


        recylerAdapter = new RecylerAdapter(dtm.getMatch().getHome().getPlayers());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(recylerAdapter);

        //TODO create save button
    }
}
