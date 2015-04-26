
package ohtu;

import javax.swing.*;

public class Nollaa implements Komento {
    
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinenTulos;
    
    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta){
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }
    
    public void suorita(){        
        sovellus.nollaa();  
        int tulos = sovellus.tulos();              
        tuloskentta.setText(""+tulos);
        
    }
    
    public void peru(){
        syotekentta.setText("peruutit edellisen laskutoimituksen!");
        sovellus.setTulos(edellinenTulos);
        tuloskentta.setText(""+sovellus.tulos());
    }
}

