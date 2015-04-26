package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Matcher testi1 = new And(new HasFewerThan(10, "goals"),
                new HasAtLeast(10, "assists"),
                new PlaysIn("PHI")
        );

        System.out.println("Alle 10 maalia JA yli 10 syöttöä, PHI:");
        for (Player player : stats.matches(testi1)) {
            System.out.println(player);
        }

        Matcher testi2 = new Or(new HasAtLeast(50, "goals"),
                new HasAtLeast(60, "assists")
        );

        System.out.println("\nAinakin 50 maalia TAI yli 60 syöttöä:");
        for (Player player : stats.matches(testi2)) {
            System.out.println(player);
        }

        Matcher testi3 = new Not(new HasFewerThan(50, "goals")
        );

        System.out.println("\nEivät listalla, jossa alle 50 maalia tehneet:");
        for (Player player : stats.matches(testi3)) {
            System.out.println(player);
        }

        PinoRakentaja query = new PinoRakentaja();

        Matcher testi4 = query.playsIn("NYR")
                .hasAtLeast(10, "goals")
                .hasFewerThan(25, "assists").build();

        System.out.println("\nPinorakentajan testi:");
        for (Player player : stats.matches(testi4)) {
            System.out.println(player);
        }

        Matcher testi5 = query.playsIn("EDM")
                .hasAtLeast(50, "points").build();

        Matcher testi6 = query.oneOf(testi4, testi5).build();

        System.out.println("\nPinorakentajan toinen testi (OR):");
        for (Player player : stats.matches(testi6)) {
            System.out.println(player);
        }
    }
}
