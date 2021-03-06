package vigier.android.beer_search;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText searchText;
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

        textView.setText("Beer Finder");
        button.setText("Search");

        ArrayList<String> beersList = new ArrayList<>();
        ArrayList<Integer> beersIdList = new ArrayList<>();
        ArrayAdapter<String> beersAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, beersList);

        listView.setAdapter(beersAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beersList.clear();
                beersIdList.clear();
                Ion.with(v.getContext())
                        .load("https://api.punkapi.com/v2/beers?beer_name=" + searchText.getText() + "&per_page=5")
                        .setLogging("ION_LOGS", Log.DEBUG)
                        .asString()
                        .setCallback(new FutureCallback<String>() {
                            @Override
                            public void onCompleted(Exception e, String result) {
                                try {
                                    JSONArray beerJsonObject = new JSONArray(result);
                                    for (int i = 0; i < beerJsonObject.length(); i++) {
                                        beersList.add(beerJsonObject.getJSONObject(i).getString("name"));
                                        beersIdList.add(beerJsonObject.getJSONObject(i).getInt("id"));
                                    }
                                    listView.setAdapter(beersAdapter);
                                } catch (JSONException jsonException) {
                                    jsonException.printStackTrace();
                                }

                            }
                        });
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent beerInfoIntent = new Intent(MainActivity.this, BeerInfoActivity.class);
                beerInfoIntent.putExtra("id", beersIdList.get(position));
                startActivity(beerInfoIntent);
            }
        });
    }
}