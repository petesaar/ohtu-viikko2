package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class AuthenticationService {

    private UserDao userDao;

    @Autowired
    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }
    
    public boolean onkoListalla(String uusiEhdokas, List<User> kayttajalista){
        for (User x : kayttajalista){
            if (x.getUsername().equals(uusiEhdokas)){
                return true;
            }
        }        
        return false;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        
        boolean epakelpoNimi = false;
        boolean epakelpoSalasana = false;
        boolean eiErikoismerkkeja = true;

        if (username.length() < 3){
            epakelpoNimi = true;
        }
        
        if (password.length() < 8){
            epakelpoSalasana = true;
        }
        
        String aakkoset = "abcdefghijklmnopqrstuvwxyz";
        for (char merkki : password.toCharArray()){
            if (aakkoset.indexOf(merkki) == -1){
                eiErikoismerkkeja = false;
            }
        }
        
        return eiErikoismerkkeja || epakelpoNimi || epakelpoSalasana;
    }
}
