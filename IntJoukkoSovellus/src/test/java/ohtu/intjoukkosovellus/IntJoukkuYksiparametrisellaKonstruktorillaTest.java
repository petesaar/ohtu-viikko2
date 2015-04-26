
package ohtu.intjoukkosovellus;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class IntJoukkuYksiparametrisellaKonstruktorillaTest extends IntJoukkoTest {
    
    @Before
    @Override
    public void setUp() {
        joukko = new IntJoukko(3);
        joukko.lisaa(10);
        joukko.lisaa(3);
    }
    
        @Test
    public void konstruktoritToimivatOikein() {
        boolean thrown = false;
        try {
            joukko = new IntJoukko(-1);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
        
        thrown = false;
        try {
            joukko = new IntJoukko(-1, -1);
        } catch (IndexOutOfBoundsException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    
    // perii kaikki testit luokasta IntJoukkoTest
}
