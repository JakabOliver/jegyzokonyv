package hu.bme.aut.jegyzokonyv.data;

public class Substitution {
    private int id;
    private String time;
    private Match match;
    private Team team;
    private Player player_down;
    private Player player_up;

    public Substitution(String time, Match match, Team team, Player player_down, Player player_up) {
        this.time = time;
        this.match = match;
        this.team = team;
        this.player_down = player_down;
        this.player_up = player_up;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Player getPlayer_down() {
        return player_down;
    }

    public void setPlayer_down(Player player_down) {
        this.player_down = player_down;
    }

    public Player getPlayer_up() {
        return player_up;
    }

    public void setPlayer_up(Player player_up) {
        this.player_up = player_up;
    }
}
