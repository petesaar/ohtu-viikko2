package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

public class PinoRakentaja {

    List<Matcher> ehdot = new ArrayList<Matcher>();

    public PinoRakentaja hasFewerThan(int value, String field) {
        ehdot.add(new HasFewerThan(value, field));
        return this;
    }

    public PinoRakentaja hasAtLeast(int value, String field) {
        ehdot.add(new HasAtLeast(value, field));
        return this;
    }

    public PinoRakentaja playsIn(String s) {
        ehdot.add(new PlaysIn(s));
        return this;
    }

    public PinoRakentaja oneOf(Matcher... matchers) {
        ehdot.add(new Or(matchers));
        return this;
    }

    public Matcher build() {
        Matcher[] matchers = {};
        matchers = ehdot.toArray(matchers);
        Matcher query = new And(matchers);
        this.ehdot = new ArrayList<Matcher>();
        return query;
    }
}
