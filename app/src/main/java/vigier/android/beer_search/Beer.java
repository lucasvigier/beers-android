package vigier.android.beer_search;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Beer {

    private String name;
    private String id;

    public Beer(JSONObject object) {
        try {
            this.name = object.getString("name");
            this.id = object.getString("id");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Beer> fromJson(JSONArray jsonObjects) {
        ArrayList<Beer> beers = new ArrayList<Beer>();

        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                beers.add(new Beer(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return beers;
    }
}