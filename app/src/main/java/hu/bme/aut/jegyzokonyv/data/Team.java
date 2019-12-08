package hu.bme.aut.jegyzokonyv.data;

import com.orm.SugarRecord;

public class Team extends SugarRecord<Team> {
    private String name;
    private Player[] players;

    public Team() {

    }

    public Team(String name) {
        this.name = name;
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

    public void setPlayers(String[] names) {
        players = new Player[names.length];
        for (int i = 0; i < names.length; i++) {
            Player player = new Player(names[i], (i + 1));
            player.setTeam_id(this.getId());
            player.save();
            players[i] = player;
        }
    }

    public Player[] getAttackers() {
        int i = 0;
        Player[] attackers = new Player[4];
        for (Player p : players) {
            if (p.getActive() == 1) {
                attackers[i++] = p;
            }
        }
        return attackers;
    }
    public Player[] getDeffenders() {
        int i = 0;
        Player[] deffenders = new Player[4];
        for (Player p : players) {
            if (p.getActive() == 2) {
                deffenders[i++] = p;
            }
        }
        return deffenders;
    }
}
