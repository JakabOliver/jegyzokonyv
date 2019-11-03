package hu.bme.aut.jegyzokonyv.data;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager instance;
    private Match match;


    private DataManager() {
        List<Player> players = new ArrayList<Player>();
        for (int i = 1; i < 10; i++) {
            players.add(new Player("name_" + i, i));
        }
        Team home = new Team("Kékvölgy", players);
        Team away = new Team("SZAC", players);
        match = new Match(home, away);
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

}