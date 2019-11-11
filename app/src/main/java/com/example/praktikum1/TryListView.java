package com.example.sugihwalyoproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class TryListView extends AppCompatActivity {

    ListView listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.try_list_view_activity);

        // initialize components
        listItem = findViewById(R.id.list_item);

        populateListView();
        listClicked();
    }

    private void populateListView(){
        ArrayList<String> arrData = new ArrayList<String>();
        arrData.add("Budogol");
        arrData.add("Waluyo");
        arrData.add("Budi");
        arrData.add("Ahmad");
        arrData.add("Yunarso");
        arrData.add("Bambang");
        arrData.add("Tukimin");
        arrData.add("Fadil");
        arrData.add("Armando");
        arrData.add("Musthofa");
        arrData.add("Pradana");
        arrData.add("Pratama");
        arrData.add("Kithil");

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                arrData
        );

        listItem.setAdapter(adapter);
    }

    private void listClicked(){
        listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(
                        getApplicationContext(),
                        "You Selected " + adapterView.getItemAtPosition(i),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }


}
