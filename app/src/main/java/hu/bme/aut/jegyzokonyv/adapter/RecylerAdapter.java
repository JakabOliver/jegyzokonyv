package hu.bme.aut.jegyzokonyv.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import hu.bme.aut.jegyzokonyv.R;
import hu.bme.aut.jegyzokonyv.data.Player;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.ViewHolder> {

    private Player[] players;

    public RecylerAdapter(Player[] players) {
        this.players = players;
    }

    @NonNull
    @Override
    public RecylerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View playerRowView =
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.lineup_player_row, parent, false);
        return new ViewHolder(playerRowView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecylerAdapter.ViewHolder holder, int position) {
        Player player = players[position];
        holder.tvName.setText(player.getName());
        holder.cbAttack.setChecked(player.getActive() == 1);
        holder.cbDefense.setChecked(player.getActive() == 2);

    }

    @Override
    public int getItemCount() {
        return players.length;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public CheckBox cbAttack;
        public CheckBox cbDefense;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            cbAttack = itemView.findViewById(R.id.cbAttack);
            cbAttack.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton v, boolean isChecked) {
                    Player player = players[getAdapterPosition()];
                    player.setAttack(isChecked);
                }
            });
            cbDefense = itemView.findViewById(R.id.cbDefense);
            cbDefense.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton v, boolean isChecked) {
                    Player player = players[getAdapterPosition()];
                    player.setDefense(isChecked);
                }
            });
        }


    }
}
