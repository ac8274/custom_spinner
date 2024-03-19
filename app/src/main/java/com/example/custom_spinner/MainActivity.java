package com.example.custom_spinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    TextView textView;
    CustomAdapter customAdapter;
    int images[];
    String countries[];
    String capitals[];
    String population[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initAll(); // initializes all arrays.

        textView = findViewById(R.id.textView);
        customAdapter = new CustomAdapter(this, images, countries,capitals);
        spinner.setAdapter(customAdapter);
        spinner.setOnItemSelectedListener(this);
    }

    private void initAll() {
        spinner = findViewById(R.id.spinner);

        images = new int[]
                {
                        R.drawable.canada,R.drawable.israel,R.drawable.russia,R.drawable.australia,
                        R.drawable.egypt,R.drawable.england,R.drawable.germany
                };

        countries = new String[]
                {
                    "Canada" , "Israel" , "Russia", "Australia" , "Egypt" , "England","Germany"
                };
        capitals = new String[]
                {
                    "Ottawa", "Jerusalem" , "Moscow" , "Canberra" , "Cairo" , "London" , "Berlin"
                };
        population = new String[]
                {
                    "38.25 million" , "9.364 million" , "143.4 million", "25.69 million",
                         "109.3 million", "55.98 million" , "83.2 million"
                };
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String str = "Country: " + countries[position] + "\nCapital: " + capitals[position] +
                "\nPopulation: " + population[position];
        textView.setText(str); // changes text view display to the string above.
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}