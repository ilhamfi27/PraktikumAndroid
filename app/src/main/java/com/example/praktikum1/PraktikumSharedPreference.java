package com.example.mygreatesthelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class PraktikumSharedPreference extends AppCompatActivity {

    Button toRemove, toRead;
    SharedPreferences mSettings;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_praktikum_shared_preference);

        toRemove = findViewById(R.id.btn_to_remove);
        toRead = findViewById(R.id.btn_to_read);

        mSettings = this.getSharedPreferences(
                "setting", Context.MODE_PRIVATE);

        editor = mSettings.edit();

        setSharedPreference();
        buttonClicked();
        checkSharedPreference();
    }

    private void setSharedPreference(){
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString("greetings", "Hai");
        editor.putString("name", "My Name Is Budogol. Nice To Meet You!");
        editor.apply();
    }
    
    private void buttonClicked(){
        toRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doIntent(ReadSharedPreferences.class);
            }
        });
        toRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit();
            }
        });
    }

    private void doIntent(Class destinationActivity){
        Intent i = new Intent(getApplicationContext(), destinationActivity);
        startActivity(i);
    }

    private void checkSharedPreference(){
        if(mSettings.contains("name")){
            Log.d("info", "It Is HERE!");
        } else {
            Log.d("info", "It Is NOT HERE!");
        }
    }
}

