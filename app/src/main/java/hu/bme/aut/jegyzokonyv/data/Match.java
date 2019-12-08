package hu.bme.aut.jegyzokonyv.data;


import com.orm.SugarRecord;

public class Match extends SugarRecord<Match> {
    private Team home;
    private Team away;
    private int homePoint = 0;
    private int awayPoint = 0;
    private int part = 0;

    public Match() {

    }

    Match(Team home, Team away) {
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

        for (Player player : players) {
            if (player.getButtonId() == buttonID) {
                return player;
            }
        }

        players = getAway().getPlayers();
        for (Player player : players) {
            if (player.getButtonId() == buttonID) {
                return player;
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

    public boolean readyToStart() {
        return this.getHome().isReady() && this.getAway().isReady();
    }
}
