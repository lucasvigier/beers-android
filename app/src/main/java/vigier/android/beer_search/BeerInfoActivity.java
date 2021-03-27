package vigier.android.beer_search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;

public class BeerInfoActivity extends AppCompatActivity {

    TextView textViewBeerInfo;
    ImageView imageViewBeer;
    TextView textViewBeerAttributes;
    TextView textViewBeerDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_info);

        textViewBeerInfo = findViewById(R.id.textViewBeerInfo);
        textViewBeerAttributes = findViewById(R.id.textViewBeerAttributes);
        textViewBeerDesc = findViewById(R.id.textViewBeerDesc);
        imageViewBeer = findViewById(R.id.imageViewBeer);

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
                        System.out.println(result);


                    }
                });

    }
}