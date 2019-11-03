package hu.bme.aut.jegyzokonyv.data;

import java.util.Timer;

public class Match {
    private int id;
    private String result;
    private Team home;
    private Team away;
    private Timer timer;

    public Match(Team home, Team away) {
        this.home = home;
        this.away = away;
        timer = new Timer();
    }

    public boolean start(){
        timer.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }
}
