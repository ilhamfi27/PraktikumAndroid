package com.example.mygreatesthelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class ReadSharedPreferences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_shared_preferences);
        getSharedPreferences();
    }

    void getSharedPreferences(){
        SharedPreferences mSettings = this.getSharedPreferences(
                "setting", Context.MODE_PRIVATE);
        String greetings = mSettings.getString("greetings", null);
        String name = mSettings.getString("name", null);

        if(mSettings.contains("name")){
            Log.d("info", greetings);
            Log.d("info", name);
        } else {
            Log.d("info", "It Is NOT HERE!");
        }
    }
}
