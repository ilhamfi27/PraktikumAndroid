package com.example.praktikum1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreBoard extends AppCompatActivity {

    private Button lButton;
    private Button rButton;
    private TextView lScore;
    private TextView rScore;

    private int leftScore = 0, rightScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        rButton = findViewById(R.id.rightButton);
        rScore = findViewById(R.id.scoreRight);
        lButton = findViewById(R.id.leftButton);
        lScore = findViewById(R.id.scoreLeft);

        scoreInit();
        rightButtonClick();
        leftButtonClick();
    }

    private void scoreInit() {
        rScore.setText(String.valueOf(rightScore));
        lScore.setText(String.valueOf(leftScore));
    }

    private void rightButtonClick(){
        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rightScore += 1;
                rScore.setText(String.valueOf(rightScore));
            }
        });
    }

    private void leftButtonClick(){
        lButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leftScore += 1;
                lScore.setText(String.valueOf(leftScore));
            }
        });
    }
}
