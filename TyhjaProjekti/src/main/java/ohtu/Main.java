package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import java.util.*;

public class Main { 

    public static void main(String[] args) throws IOException {
        int tehdytYhteensa = 0;
        int aikaaMennyt = 0;
        String studentNr = "014181494";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats-2015.herokuapp.com/students/"+studentNr+"/submissions";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream =  method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] tiedot = mapper.fromJson(bodyText, Submission[].class);
               
        System.out.println("\n"+"Opiskelijanumero: "+tiedot[0].getStudent_number()+"\n");
        
        for(Submission s : tiedot){            
            System.out.println("   "+s.toString());
            tehdytYhteensa += s.kaikkiTehdyt();
            aikaaMennyt += s.getHours();
        }
        System.out.println("\n"+"Yhteensä tehtäviä on tehtynä "+tehdytYhteensa+" ja aikaa palanut "+aikaaMennyt+" tuntia."+"\n");
/**
        System.out.println("Oliot:");
        for (Submission submission : tiedot) {
            System.out.println(submission);
        }
**/
    }
}