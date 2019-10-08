package com.example.praktikum1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MultiLangual extends AppCompatActivity {
    Spinner spLanguages;
    TextView word1, word2, word3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_langual);
        componentInit();

        fillLanguagesSpinner();
        languageSpinnerOnClick();
    }

    private void componentInit(){
        spLanguages = findViewById(R.id.spLanguages);
        word1 = findViewById(R.id.word1);
        word2 = findViewById(R.id.word2);
        word3 = findViewById(R.id.word3);
    }

    private void fillLanguagesSpinner(){
        String[] languages = getResources().getStringArray(R.array.languages);
        ArrayAdapter<String> arrAdapter = new ArrayAdapter<String>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                languages
        );
        spLanguages.setAdapter(arrAdapter);
    }

    private void languageSpinnerOnClick(){
        spLanguages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        break;
                    case 1:
                        setLocale("en");
                        break;
                    case 2:
                        setLocale("es");
                        break;
                    case 3:
                        setLocale("in");
                        break;
                    case 4:
                        setLocale("su");
                        break;
                    case 5:
                        setLocale("jv");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setLocale(String lang){
        Locale local = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = local;
        res.updateConfiguration(conf, dm);
        Intent i = new Intent(this, MultiLangual.class);
        startActivity(i);
    }
}
