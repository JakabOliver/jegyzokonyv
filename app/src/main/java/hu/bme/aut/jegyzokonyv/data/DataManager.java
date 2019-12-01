package hu.bme.aut.jegyzokonyv.data;

public class DataManager {
    private static DataManager instance;
    private Match match;


    private DataManager() {
        Player[] players = new Player[10];
        for (int i = 1; i < 10; i++) {
            players[i] = new Player("name_" + i, i, true);
        }

        Player[] players2 = {
                new Player("Olivér", 31, true),
                new Player("Attila", 8, true),
                new Player("Jana", 12, true),
                new Player("Kriszti", 4, true),
                new Player("Gergő", 9, true),
                new Player("Dömötör", 10, true),
                new Player("Fanni", 13, true),
                new Player("Enikő", 24, true),
                new Player("Noémi", 21, false),
        };

        Team home = new Team("Kékvölgy", players2);
        Team away = new Team("SZAC", players);

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