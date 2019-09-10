package com.example.praktikum1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillSpinner();
        buttonSubmitOnClick();
    }

    private void fillSpinner(){
        Spinner spJenisKelamin = findViewById(R.id.spJenisKelamin);

        ArrayAdapter<CharSequence> arrAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.jenisKelaminData,
                R.layout.support_simple_spinner_dropdown_item
        );
        spJenisKelamin.setAdapter(arrAdapter);
    }

    private void buttonSubmitOnClick(){
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIntent();
            }
        });
    }

    private void startIntent(){
        EditText etNama, etTempatLahir, etTanggalLahir, etYoutuber, etTimBola;
        Spinner spJenisKelamin;
        Bundle extras = new Bundle();

        etNama          = findViewById(R.id.etName);
        etTempatLahir   = findViewById(R.id.etTempatLahir);
        etTanggalLahir  = findViewById(R.id.dateTglLahir);
        etYoutuber      = findViewById(R.id.etYoutuber);
        etTimBola       = findViewById(R.id.etTimBola);
        spJenisKelamin  = findViewById(R.id.spJenisKelamin);

        extras.putString("nama", etNama.getText().toString());
        extras.putString("tempatLahir", etTempatLahir.getText().toString());
        extras.putString("tanggalLahir", etTanggalLahir.getText().toString());
        extras.putString("youtuber", etYoutuber.getText().toString());
        extras.putString("timBola", etTimBola.getText().toString());
        extras.putString("jenisKelamin", spJenisKelamin.getSelectedItem().toString());

        final Intent i = new Intent(this, BiodataActivity.class);
        i.putExtras(extras);
        startActivity(i);
    }
}
