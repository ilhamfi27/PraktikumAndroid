package com.example.praktikum1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

public class PreAssessment extends AppCompatActivity {

    private Spinner countrySpinner;
    private RatingBar countryRateBar;

    private Boolean countryChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_assessment);
        countrySpinner = findViewById(R.id.countries);
        countryRateBar = findViewById(R.id.countryRate);
        giveRating();
        countrySpinnerChanged();
    }

    private void giveRating(){
        countryRateBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                String country = countrySpinner.getSelectedItem().toString();
                makeToast(country, rating);
            }
        });
    }

    private void makeToast(String country, float rating){
        String message = "You set rate " + rating + " for " + country;
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void countrySpinnerChanged(){
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                countryRateBar.setRating(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
