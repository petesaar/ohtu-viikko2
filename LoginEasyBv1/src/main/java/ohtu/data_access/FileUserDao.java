package ohtu.data_access;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author Pete
 */
@Component
public class FileUserDao implements UserDao {

    private String tiedostonNimi;
    private File tiedosto;
    private Scanner skanneri;
    private FileWriter kirjuri;
    private List<User> kayttajalista;

    public FileUserDao(String filu) {
        this.kayttajalista = new ArrayList();
        this.tiedostonNimi = filu;
    }

    public List<User> listAll() {        
        try {
            lueTiedosto();
            return kayttajalista;
        } catch (FileNotFoundException fiba) {
            try{
            kirjuri = new FileWriter(new File(tiedostonNimi));
            System.out.println("Tiedostoa ei voitu avata: " + tiedosto);
            }catch (IOException virhe){
                System.out.println("Tiedostoa ei voitu muodostaa: "+virhe.getMessage());
            }
        }        
        return new ArrayList();
    }
    
    public void lueTiedosto() throws FileNotFoundException{                
        tiedosto = new File(tiedostonNimi);
        skanneri = new Scanner(tiedosto);
        System.out.println("avattiin tiedosto "+tiedosto);
        kayttajalista.clear();
        while(skanneri.hasNextLine()){
            String nimi = skanneri.nextLine();
            String salasana = skanneri.nextLine();
            User kayttaja = new User(nimi, salasana);
            //System.out.println("lisättiin listalle "+kayttaja.getUsername());
            kayttajalista.add(kayttaja);
        }
        skanneri.close();
    }

    public User findByName(String name){
        User kayttaja = null;
        
        for (User x : kayttajalista){
            if (x.getUsername().equals(name)){
                return x;
            }
        }        
        return kayttaja;
    }
    
    public void add(User kayttaja){
        kayttajalista.add(kayttaja);
        try {
            kirjoitaTiedostoon();
        }catch (IOException fiba) {
            System.out.println("Kirjoittaminen tiedostoon ei onnistu: " + fiba.getMessage());
        }
    }
    
    public void kirjoitaTiedostoon() throws IOException{
        tiedosto = new File(tiedostonNimi);
        kirjuri = new FileWriter(tiedosto);
        for (User x : kayttajalista){
            kirjuri.write(x.getUsername() + "\n" + x.getPassword() + "\n");
        }
        kirjuri.close();
    }
}
