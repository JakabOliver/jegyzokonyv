package hu.bme.aut.jegyzokonyv.data;


import com.orm.SugarRecord;

public class Match extends SugarRecord<Match> {
    private String result;
    private Team home;
    private Team away;
    private int homePoint = 0;
    private int awayPoint = 0;
    private int part = 0;

    public Match() {

    }

    public Match(Team home, Team away) {
        this.home = home;
        this.away = away;
    }


    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public Player getPlayerByButtonId(int buttonID) {
        Player[] players = getHome().getPlayers();

        for (int i = 0; i < players.length; i++) {
            if (players[i].getButtonId() == buttonID) {
                return players[i];
            }
        }

        players = getAway().getPlayers();
        for (int i = 0; i < players.length; i++) {
            if (players[i].getButtonId() == buttonID) {
                return players[i];
            }
        }
        return null;
    }

    public void homeTeamScored() {
        homePoint++;
    }

    public void awayTeamScored() {
        awayPoint++;
    }

    public int getHomePoint() {
        return homePoint;
    }

    public int getAwayPoint() {
        return awayPoint;
    }

    public int getPart() {
        return part;
    }

    public void setPart(int part) {
        this.part = part;
    }

    public void startNextPart() {
        this.part++;
    }
}
