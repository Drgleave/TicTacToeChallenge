package com.example.android.tic_tac_toechallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnPvP = findViewById(R.id.pvp);
        btnPvP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TwoPlayerSelectBoard.class);
                startActivity(intent);
                //log function
                Log.v("Button", "Button Clicked");
            }
        });
        Button btnPvC = findViewById(R.id.pvc);
        btnPvC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OnePlayerSelectBoard.class);
                startActivity(intent);
                //log function
                Log.v("Button", "Button Clicked");

            }
        });

    }
}

