package ohtu.verkkokauppa;

public class Kauppa implements KauppaInterface {

    public Varasto varasto;
    private Pankki pankki;
    private Ostoskori ostoskori;
    private Viitegeneraattori viitegeneraattori;
    private String kaupanTili;

    public Kauppa(Varasto var, Pankki pan, Viitegeneraattori vii) {
        varasto = var;
        pankki = pan;
        viitegeneraattori = vii;
        kaupanTili = "33333-44455";        
    }

    @Override
    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    @Override
    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    @Override
    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
            if(0 < 1){
                //checkstylen testi nested if
            }
            for (int i=0; i<2; i++){
                for (int j=0; j<2; j++){
                    //checkstylen testi nested for
                }
            }
                    int x = 2; //checkstylen testi sisennys
                    
            for (int i=0; i<2; i++){
                for (int j=0; j<2; j++){
                    //checkstylen testi copy-paste
                }
            }
        }
    }

    @Override
    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
