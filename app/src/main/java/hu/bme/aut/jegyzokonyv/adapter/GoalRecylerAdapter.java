package hu.bme.aut.jegyzokonyv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

import hu.bme.aut.jegyzokonyv.R;
import hu.bme.aut.jegyzokonyv.data.DataManager;
import hu.bme.aut.jegyzokonyv.data.Goal;
import hu.bme.aut.jegyzokonyv.data.Match;

public class GoalRecylerAdapter extends RecyclerView.Adapter<GoalRecylerAdapter.ViewHolder> {

    private List<Goal> goals;

    public GoalRecylerAdapter(List<Goal> goals) {
        this.goals = goals;
    }

    @NonNull
    @Override
    public GoalRecylerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View goalRowView =
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.result_goal_row, parent, false);
        return new ViewHolder(goalRowView);
    }

    @Override
    public void onBindViewHolder(@NonNull GoalRecylerAdapter.ViewHolder holder, int position) {
        Goal goal = goals.get(position);
        Match match = DataManager.getInstance().getMatch();
        if (goal.getTeam().getId().equals(match.getHome().getId())) {
            holder.homeTextView.setText(String.format(Locale.ENGLISH, "%s - %d", goal.getPlayer().getName(), goal.getTime()));
        } else {
            holder.awayTextView.setText(String.format(Locale.ENGLISH, "%s - %d", goal.getPlayer().getName(), goal.getTime()));
        }
    }

    @Override
    public int getItemCount() {
        return goals.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView homeTextView;
        TextView awayTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            homeTextView = itemView.findViewById(R.id.homeTextView);
            awayTextView = itemView.findViewById(R.id.awayTextView);
        }
    }
}
