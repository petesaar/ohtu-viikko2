
package ohtu.verkkokauppa;

/**
 *
 * @author Pete
 */
public interface KauppaInterface {

    void aloitaAsiointi();

    void lisaaKoriin(int id);

    void poistaKorista(int id);

    boolean tilimaksu(String nimi, String tiliNumero);
    
}
