package com.example.praktikum1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class Quiz3 extends AppCompatActivity {

    RadioButton rbJawaban4;
    Button btnTryAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz3);

        btnTryAgain = findViewById(R.id.btnTryAgain);

        showStarterDialog();
        btnTryAgainOnClick();
    }

    private void btnTryAgainOnClick(){
        btnTryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showStarterDialog();
            }
        });
    }

    private void showStarterDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();

        View view = inflater.inflate(R.layout.quiz3, null);
        builder.setView(view);

        rbJawaban4 = view.findViewById(R.id.rbJawaban4);

        builder.setPositiveButton("Submit", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(rbJawaban4.isChecked()){
                    setPushNotification();
                    Toast.makeText(getApplicationContext(), "Benar", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create();
        builder.show();
    }

    private void setPushNotification(){
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, "0");
        builder.setSmallIcon(R.drawable.mu_logo);
        builder.setContentTitle("Kau Berhasil!");
        builder.setContentText("Selamat! Kau telah menyelesaikan Quiz!");
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat =
                NotificationManagerCompat.from(this);

        notificationManagerCompat.notify(101, builder.build());
    }
}
