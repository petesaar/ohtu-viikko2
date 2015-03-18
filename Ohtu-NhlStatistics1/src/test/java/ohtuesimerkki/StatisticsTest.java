
package ohtuesimerkki;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {
    
    Statistics x;
    
    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };     
    
    public StatisticsTest() {
    }    
   
    @Before
    public void setUp() {
        x = new Statistics(readerStub);
    }    

    /**
     * Test of search method, of class Statistics.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        String nimi = "Semenko";
        Player pelaaja = x.search(nimi);        
        assertEquals(pelaaja.getName(), nimi);
        Player pelaaja2 = x.search("eioo");        
        assertNull(pelaaja2);
        
    }

    /**
     * Test of team method, of class Statistics.
     */
    @Test
    public void testTeam() {
        System.out.println("team");
        String joukkue = "EDM";
        List<Player> team = x.team(joukkue);
        
        assertEquals(team.size(), 3);
    }

    /**
     * Test of topScorers method, of class Statistics.
     */
    @Test
    public void testTopScorers() {
        System.out.println("topScorers");
        int montako = 2;        
        List<Player> parhaat = x.topScorers(montako);
        
        assertEquals(parhaat.size(), 2);
        assertEquals(parhaat.get(0).getName(), "Gretzky");
    }
    
}
