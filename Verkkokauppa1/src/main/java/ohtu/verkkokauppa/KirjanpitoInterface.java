
package ohtu.verkkokauppa;

import java.util.ArrayList;

/**
 *
 * @author Pete
 */
public interface KirjanpitoInterface {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
