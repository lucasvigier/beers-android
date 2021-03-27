package vigier.android.beer_search;

import java.io.Serializable;
import java.util.ArrayList;

public class Beers implements Serializable {
    ArrayList<Beer> beers;

    public Beers() {
        beers = new ArrayList<Beer>();
    }

    public ArrayList<Beer> getBeers() {
        return beers;
    }

    public void add(Beer beer) {
        beers.add(beer);
    }

    public void remove(Beer beer) {
        beers.remove(beer);
    }

    public static Beers init() {
        return new Beers();
    }
}
