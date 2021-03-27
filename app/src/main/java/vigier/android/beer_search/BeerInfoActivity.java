package vigier.android.beer_search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;

public class BeerInfoActivity extends AppCompatActivity {

    TextView textViewBeerName;
    ImageView imageViewBeer;
    TextView textViewBeerAttributeFirstBrew;
    TextView textViewBeerDesc;
    TextView textViewBeerAttributesSRM;
    TextView textViewBeerAttributesPH;
    TextView textViewBeerAttributesABV;
    TextView textViewBeerAttributesSubTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_info);

        textViewBeerName = findViewById(R.id.textViewBeerName);
        textViewBeerAttributeFirstBrew = findViewById(R.id.textViewBeerAttributeFirstBrew);
        textViewBeerDesc = findViewById(R.id.textViewBeerDesc);
        imageViewBeer = findViewById(R.id.imageViewBeer);
        textViewBeerAttributesSRM = findViewById(R.id.textViewBeerAttributesSRM);
        textViewBeerAttributesPH = findViewById(R.id.textViewBeerAttributesPH);
        textViewBeerAttributesABV = findViewById(R.id.textViewBeerAttributesABV);
        textViewBeerAttributesSubTitle = findViewById(R.id.textViewBeerAttributesSubTitle);

        Bundle extras = getIntent().getExtras();

        int id = extras.getInt("id");
        System.out.println(id);

        Ion.with(super.getBaseContext())
                .load(("https://api.punkapi.com/v2/beers/" + id))
                .setLogging("ION_LOGS", Log.DEBUG)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {
                        try {
                            JSONArray beerJsonObject = new JSONArray(result);
                            textViewBeerDesc.setText(beerJsonObject.getJSONObject(0).getString("description"));
                            textViewBeerName.setText(beerJsonObject.getJSONObject(0).getString("name"));
                            Picasso.get().load(beerJsonObject.getJSONObject(0).getString("image_url")).into(imageViewBeer);
                            textViewBeerAttributesSRM.setText(beerJsonObject.getJSONObject(0).getString("srm"));
                            textViewBeerAttributesPH.setText(beerJsonObject.getJSONObject(0).getString("ph"));
                            textViewBeerAttributesABV.setText(beerJsonObject.getJSONObject(0).getString("abv"));
                            textViewBeerAttributesSubTitle.setText(beerJsonObject.getJSONObject(0).getString("tagline"));
                            textViewBeerAttributeFirstBrew.setText(beerJsonObject.getJSONObject(0).getString("first_brewed"));

                        } catch (JSONException jsonException) {
                            jsonException.printStackTrace();
                        }


                    }
                });

    }
}