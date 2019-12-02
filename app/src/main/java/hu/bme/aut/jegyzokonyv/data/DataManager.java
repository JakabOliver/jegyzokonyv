package hu.bme.aut.jegyzokonyv.data;

public class DataManager {
    private static DataManager instance;
    private Match match;


    private DataManager() {
        Player[] players = {
                new Player("Tamás", 1, 2, true),
                new Player("Balázs", 2, 2, true),
                new Player("Emese", 3, 2, true),
                new Player("Tímea", 4, 2, true),
                new Player("Viktor", 5, 2, true),
                new Player("Zsolt", 6, 2, true),
                new Player("Noémi", 7, 2, true),
                new Player("Eszter", 8, 2, true),
        };
        Player[] players2 = {
                new Player("Olivér", 31, 1, true),
                new Player("Attila", 8, 1, true),
                new Player("Jana", 12, 1, true),
                new Player("Kriszti", 4, 1, true),
                new Player("Gergő", 9, 1, true),
                new Player("Dömötör", 10, 1, true),
                new Player("Fanni", 13, 1, true),
                new Player("Enikő", 24, 1, true),
                new Player("Noémi", 21, 1, false),
        };

        Team home = new Team(1, "Kékvölgy", players2);
        Team away = new Team(2, "SZAC", players);

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