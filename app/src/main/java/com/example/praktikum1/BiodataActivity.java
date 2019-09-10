package com.example.praktikum1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BiodataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata);

        showPassedItems();
    }

    private void showPassedItems(){
        TextView tvNama, tvTempatLahir, tvTanggalLahir, tvYoutuber, tvTimBola, tvJenisKelamin;
        String nama, tempatLahir, tanggalLahir, youtuber, timBola, jenisKelamin;
        Bundle extras = getIntent().getExtras();

        tvNama          = findViewById(R.id.tvNama);
        tvTempatLahir   = findViewById(R.id.tvTempatLahir);
        tvTanggalLahir  = findViewById(R.id.tvTanggalLahir);
        tvYoutuber      = findViewById(R.id.tvYoutuber);
        tvTimBola       = findViewById(R.id.tvTimBola);
        tvJenisKelamin  = findViewById(R.id.tvJenisKelamin);

        nama = extras.getString("nama");
        tempatLahir = extras.getString("tempatLahir");
        tanggalLahir = extras.getString("tanggalLahir");
        youtuber = extras.getString("youtuber");
        timBola = extras.getString("timBola");
        jenisKelamin = extras.getString("jenisKelamin");

        tvNama.setText(nama);
        tvTempatLahir.setText(tempatLahir);
        tvTanggalLahir.setText(tanggalLahir);
        tvYoutuber.setText(youtuber);
        tvTimBola.setText(timBola);
        tvJenisKelamin.setText(jenisKelamin);
    }
}
