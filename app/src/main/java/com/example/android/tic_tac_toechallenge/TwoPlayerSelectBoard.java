package com.example.android.tic_tac_toechallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class TwoPlayerSelectBoard extends AppCompatActivity {

    private EditText Player1;
    private EditText Player2;
    private String player1Val;
    private String player2Val;
    private RadioButton board3;
    private RadioButton board5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_player_select_board);

        //find player names
        Player1 = findViewById(R.id.player1);
        Player2 = findViewById(R.id.player2);
        // find board selection
        board3 = findViewById(R.id.radio3);
        board5 = findViewById(R.id.radio5);
        //onclick listener
        Button beginGame = findViewById(R.id.begin_game);
        beginGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (board3.isChecked()) {
                    Intent intent = new Intent(TwoPlayerSelectBoard.this, MainTwoPlayerBoard3Activity.class);
                    player1Val = Player1.getText().toString();
                    player2Val = Player2.getText().toString();
                    intent.putExtra("Value1",player1Val);
                    intent.putExtra("Value2",player2Val);
                    startActivity(intent);
                    //log function
                    Log.v("ImageButton", "Button Clicked");
                }
                if (board5.isChecked()){
                    Intent intent = new Intent(TwoPlayerSelectBoard.this, Main5x5TwoPlayerActivity.class);
                    player1Val = Player1.getText().toString();
                    player2Val = Player2.getText().toString();
                    intent.putExtra("Name1", player1Val);
                    intent.putExtra("Name2", player2Val);
                    startActivity(intent);
                    //log function
                    Log.v("ImageButton", "Button Clicked");
                }
                //else {
                //Toast.makeText(this, "You must select a game board", Toast.LENGTH_SHORT).show();
                //}
            }
        });

    }
}
