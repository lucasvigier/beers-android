package vigier.android.mini_projet_adnroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.SeekBar;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText searchText;
    SeekBar seekBar;
    TextView textView;
    ListView listView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        searchText = findViewById(R.id.searchText);
        textView = findViewById(R.id.textView);
        listView = findViewById(R.id.listView);

        textView.setText("Beers");
        button.setText("Search");

        ArrayList<String> beersList = new ArrayList<String>();

        ArrayAdapter beersAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, beersList);
        listView.setAdapter(beersAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ion.with(v.getContext())
                        .load("https://api.punkapi.com/v2/beers?beer_name=" + searchText.getText() + "&per_page=5")
                        .setLogging("ION_LOGS", Log.DEBUG)
                        .asString()
                        .setCallback(new FutureCallback<String>() {
                            @Override
                            public void onCompleted(Exception e, String result) {
                                
                            }
                        });

            }
        });
    }
}