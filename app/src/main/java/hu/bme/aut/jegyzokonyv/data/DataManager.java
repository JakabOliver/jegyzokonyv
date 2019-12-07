package hu.bme.aut.jegyzokonyv.data;

import java.util.List;

public class DataManager {
    private static DataManager instance;
    private Match match;


    private DataManager() {
        List<Match> matches = Match.listAll(Match.class);
        if (matches.isEmpty()) {
            match = DataManager.init();
        } else {
            match = matches.get(0);
        }
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public static void destroyData() {
        Match.deleteAll(Match.class);
        Team.deleteAll(Team.class);
        Player.deleteAll(Player.class);
        Goal.deleteAll(Goal.class);
    }

    public static Match init() {
        String[] names = {
                "Olivér",
                "Attila",
                "Jana",
                "Kriszti",
                "Gergő",
                "Dömötör",
                "Fanni",
                "Enikő",
        };
        String[] names2 = {
                "Tamás",
                "Balázs",
                "Emese",
                "Tímea",
                "Viktor",
                "Zsolt",
                "Noémi",
                "Eszter",
        };

        Team home = new Team("Kékvölgy");
        home.save();
        home.setPlayers(names);
        home.save();

        Team away = new Team("SZAC");
        away.save();
        away.setPlayers(names2);
        away.save();


        Match match = new Match(home, away);
        match.save();
        return match;
    }

    public Match getMatch() {
        return match;
    }

}