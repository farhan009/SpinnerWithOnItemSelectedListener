package com.example.spinnerwithonitemselectedlistener;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private String[] countryNames;
    private String[] countryPopulation;
    int[] flags = {R.drawable.bangladesh, R.drawable.canada, R.drawable.germany, R.drawable.india, R.drawable.london, R.drawable.usa};
    private Boolean isFirstSelected = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner_id);
        countryNames = getResources().getStringArray(R.array.country_names);
        countryPopulation = getResources().getStringArray(R.array.country_population);

        CustomAdapter customAdapter = new CustomAdapter(this, flags, countryNames, countryPopulation);
        spinner.setAdapter(customAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (isFirstSelected == true){
                    isFirstSelected = false;
                } else{
                    Toast.makeText(getApplicationContext(), countryNames[position]+" is selected", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
