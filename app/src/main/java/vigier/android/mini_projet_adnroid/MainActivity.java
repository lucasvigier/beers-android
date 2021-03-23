package vigier.android.mini_projet_adnroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText searchText;
    SeekBar seekBar;
    TextView textView;
    ScrollView scrollView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        searchText = findViewById(R.id.searchText);
        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);
        scrollView = findViewById(R.id.scrollView);

        textView.setText("Beers");
        button.setText("Search");


    }
}