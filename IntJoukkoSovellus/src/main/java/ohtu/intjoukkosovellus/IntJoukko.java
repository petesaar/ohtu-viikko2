package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;     // luotava uusi taulukko on näin paljon isompi kuin vanha    
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] lukuJono;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this.alustaKentat(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        if (kapasiteetti <= 0) {
            throw new IndexOutOfBoundsException("Kapasiteetin on oltava nollaa suurempi");
        }
        this.kasvatuskoko = OLETUSKASVATUS;
        this.alustaKentat(kapasiteetti, kasvatuskoko);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti <= 0) {
            throw new IndexOutOfBoundsException("Kapasiteetin on oltava nollaa suurempi");
        }
        if (kasvatuskoko <= 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoon on oltava nollaa suurempi");
        }
        this.alustaKentat(kapasiteetti, kasvatuskoko);
    }

    public void alustaKentat(int kapasiteetti, int kasvatuskoko) {
        lukuJono = new int[kapasiteetti];
        for (int i = 0; i < lukuJono.length; i++) {
            lukuJono[i] = 0;
        }
        alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            lukuJono[alkioidenLkm] = luku;
            alkioidenLkm++;            
            if (alkioidenLkm == lukuJono.length){
                kasvataTaulukkoa();
            }
            return true;
        }
        return false;
    }
    
    public void kasvataTaulukkoa(){
        int[] uusiJono = new int[lukuJono.length + kasvatuskoko];
        kopioiTaulukko(lukuJono, uusiJono);
        lukuJono = uusiJono;
    }    
    
    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukuJono[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == lukuJono[i]) {
                lukuJono[i] = lukuJono[alkioidenLkm-1];
                lukuJono[alkioidenLkm - 1] = 0;
                alkioidenLkm--;
                return true;
            }
        }
        return false;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else if (alkioidenLkm == 1) {
            return "{" + lukuJono[0] + "}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += lukuJono[i];
                tuotos += ", ";
            }
            tuotos += lukuJono[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = lukuJono[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            x.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            x.lisaa(bTaulu[i]);
        }
        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    y.lisaa(bTaulu[j]);
                }
            }
        }
        return y;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();
        int[] aTaulu = a.toIntArray();
        int[] bTaulu = b.toIntArray();
        for (int i = 0; i < aTaulu.length; i++) {
            z.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            z.poista(i);
        }
        return z;
    }
}
