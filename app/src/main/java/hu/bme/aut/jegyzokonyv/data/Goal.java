package hu.bme.aut.jegyzokonyv.data;


import com.orm.SugarRecord;

public class Goal extends SugarRecord<Goal> {
    private Team team;
    private long time;
    private Player player;
    private Match match;

    public Goal() {

    }

    public Goal(Player player, Team team, Match match, long time) {
        this.team = team;
        this.time = time;
        this.player = player;
        this.match = match;
    }


    public Team getTeam() {
        return team;
    }


    public long getTime() {
        return time;
    }


    public Player getPlayer() {
        return player;
    }
}
