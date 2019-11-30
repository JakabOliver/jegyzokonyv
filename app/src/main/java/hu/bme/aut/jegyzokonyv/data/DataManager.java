package hu.bme.aut.jegyzokonyv.data;

public class DataManager {
    private static DataManager instance;
    private Match match;


    private DataManager() {
        Player[] players = new Player[10];
        for (int i = 1; i < 10; i++) {
            players[i] = new Player("name_" + i, i);
        }

        Player[] players2 = {
                new Player("Olivér", 31),
                new Player("Attila", 8),
                new Player("Jana", 12),
                new Player("Kriszti", 4),
                new Player("Gergő", 9),
                new Player("Dömötör", 10),
                new Player("Fanni", 13),
                new Player("Enikő", 24),
                new Player("Noémi", 21),
        };

        Team home = new Team("Kékvölgy", players2);
        Player[] starter = new Player[8];
        for (int i = 0; i < 8; i++) {
            starter[i] = home.getPlayers()[i];
        }
        home.setStarterPlayers(starter);
        Team away = new Team("SZAC", players);
        away.setStarterPlayers(starter);

        match = new Match(home, away);
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public Match getMatch() {
        return match;
    }
}