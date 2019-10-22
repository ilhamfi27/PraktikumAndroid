package com.example.praktikum1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.new_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                Toast.makeText(
                        getApplicationContext(),
                        "Menu 1 Dipilih",
                        Toast.LENGTH_SHORT
                ).show();
                return true;

            case R.id.menu2:
                Toast.makeText(
                        getApplicationContext(),
                        "Menu 2 Dipilih",
                        Toast.LENGTH_SHORT
                ).show();
                return true;

            default:
                return true;
        }
    }
}
