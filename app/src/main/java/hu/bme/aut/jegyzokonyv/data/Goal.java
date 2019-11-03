package hu.bme.aut.jegyzokonyv.data;

public class Goal {
    private int id;
    private Team team;
    private int time;
    private Player player;
    private Match match;

    public Goal(Team team, int time, Player player, Match match) {
        this.team = team;
        this.time = time;
        this.player = player;
        this.match = match;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }
}
