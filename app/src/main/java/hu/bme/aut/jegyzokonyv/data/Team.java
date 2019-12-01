package hu.bme.aut.jegyzokonyv.data;

public class Team {
    private int id;
    private String name;
    private Player[] players;
    public int[] buttonIDPlayerID;

    public Team(String name, Player[] players) {
        this.name = name;
        this.players = players;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

}
