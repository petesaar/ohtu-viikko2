package ohtu;

import java.util.HashMap;

public class Submission {

    private String student_number;
    private int week;
    private int hours;

    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public int kaikkiTehdyt() {

        HashMap<Integer, Boolean> tehtavat = new HashMap<Integer, Boolean>();

        tehtavat.put(1, a1);
        tehtavat.put(2, a2);
        tehtavat.put(3, a3);
        tehtavat.put(4, a4);
        tehtavat.put(5, a5);
        tehtavat.put(6, a6);
        tehtavat.put(7, a7);
        tehtavat.put(8, a8);
        tehtavat.put(9, a9);
        tehtavat.put(10, a10);
        tehtavat.put(11, a11);
        tehtavat.put(12, a12);
        tehtavat.put(13, a13);
        tehtavat.put(14, a14);
        tehtavat.put(15, a15);
        tehtavat.put(16, a16);
        tehtavat.put(17, a17);
        tehtavat.put(18, a18);
        tehtavat.put(19, a19);
        tehtavat.put(20, a20);
        tehtavat.put(21, a21);
        
        int yhteensa = 0;
        
        for (int i = 1; i < tehtavat.size(); i++) {
            if (tehtavat.get(i) == true) {
                yhteensa++;
            }
        }

        return yhteensa;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return "Viikolla " + week + " tuli tehtyä " + this.kaikkiTehdyt() + " tehtävää, joihin kului aikaa " + hours + " tuntia.";
    }

}
