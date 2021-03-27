package vigier.android.beer_search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class BeerInfoActivity extends AppCompatActivity {

    TextView textViewBeerInfo;
    TextView textViewBeerAttributes;
    TextView textViewBeerDesc;
    ImageView imageViewBeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_info);

        textViewBeerInfo = findViewById(R.id.textViewBeerName);
        textViewBeerAttributes = findViewById(R.id.textViewBeerAttributeFirstBrew);
        textViewBeerDesc = findViewById(R.id.textViewBeerDesc);
        imageViewBeer = findViewById(R.id.imageViewBeer);

        Bundle extras = getIntent().getExtras();

        int id = extras.getInt("id");

        Ion.with(super.getBaseContext())
                .load("https://api.punkapi.com/v2/beers" + id)
                .setLogging("ION_LOGS", Log.DEBUG)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String result) {

                    }
                });

    }
}