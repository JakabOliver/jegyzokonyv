package hu.bme.aut.jegyzokonyv;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hu.bme.aut.jegyzokonyv.adapter.GoalRecylerAdapter;
import hu.bme.aut.jegyzokonyv.adapter.PlayerRecylerAdapter;
import hu.bme.aut.jegyzokonyv.data.DataManager;
import hu.bme.aut.jegyzokonyv.data.Goal;
import hu.bme.aut.jegyzokonyv.data.Match;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Match match = DataManager.getInstance().getMatch();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView resultTV = findViewById(R.id.resultTextView);
        resultTV.setText(match.getHome().getName() + " - " + match.getAway().getName() + "  " + match.getHomePoint() + ":" + match.getAwayPoint());

        final RecyclerView recyclerView = findViewById(R.id.resultRecyclerView);
        List<Goal> goals = Goal.find(Goal.class, "match = ? ", String.valueOf(match.getId()));
        GoalRecylerAdapter goalRecylerAdapter = new GoalRecylerAdapter(goals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(goalRecylerAdapter);
    }
}
