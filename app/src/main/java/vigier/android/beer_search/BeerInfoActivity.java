package vigier.android.beer_search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BeerInfoActivity extends AppCompatActivity {

    TextView textViewBeerInfoTitle;
    TextView textViewBeerAttributes;
    TextView textViewBeerDesc;
    ImageView imageViewBeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beer_info);

        textViewBeerInfoTitle = findViewById(R.id.textViewBeerInfo);
        textViewBeerAttributes = findViewById(R.id.textViewBeerAttributes);
        textViewBeerDesc = findViewById(R.id.textViewBeerDesc);
        imageViewBeer = findViewById(R.id.imageViewBeer);
    }
}