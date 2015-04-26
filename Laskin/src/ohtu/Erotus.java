
package ohtu;

import javax.swing.*;

public class Erotus implements Komento {
    
    private Sovelluslogiikka sovellus;
    private JTextField tuloskentta;
    private JTextField syotekentta;
    private int edellinenTulos;
    
    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta){
        this.sovellus = sovellus;
        this.syotekentta = syotekentta;
        this.tuloskentta = tuloskentta;
    }
    
    public void suorita(){        
        int syote = Integer.parseInt(syotekentta.getText());
        edellinenTulos = Integer.parseInt(tuloskentta.getText());
        sovellus.miinus(syote);
        tuloskentta.setText(""+sovellus.tulos());        
        syotekentta.setText("");
    }
    
    public void peru(){
        syotekentta.setText("peruutit edellisen laskutoimituksen!");
        sovellus.setTulos(edellinenTulos);
        tuloskentta.setText(""+sovellus.tulos());
    }
}

