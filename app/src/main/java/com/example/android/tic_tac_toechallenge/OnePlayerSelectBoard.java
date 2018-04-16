package com.example.android.tic_tac_toechallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class OnePlayerSelectBoard extends AppCompatActivity {

    private EditText Player;
    private String Player1Val;
    private int Extra_Player;
    private RadioButton board3;
    private RadioButton board5;
    private RadioButton pick_o;
    private RadioButton pick_x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player_select_board);
        //find player names
        Player = findViewById(R.id.editText);
        // find board selection
        board3 = findViewById(R.id.size3);
        board5 = findViewById(R.id.size5);
        pick_o = findViewById(R.id.select_o);
        pick_x = findViewById(R.id.select_x);
        //onclick listener
        Button startGame = findViewById(R.id.startGame);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pick_o.isChecked()) {
                Extra_Player = Extra_Player + 1;
            } else if (pick_x.isChecked()) {
                Extra_Player = Extra_Player + 2;
            }
                if (board3.isChecked()) {
                    Intent intent = new Intent(OnePlayerSelectBoard.this, Main3SinglePlayerActivity.class);
                    Player1Val = Player.getText().toString();
                    intent.putExtra("Name", Player1Val);
                    intent.putExtra("Choice", Extra_Player);
                    startActivity(intent);
                    //log function
                    Log.v("3x3Button", "Button Clicked");
                }
                if (board5.isChecked()) {
                    Intent i = new Intent(OnePlayerSelectBoard.this, Main5SinglePlayerActivity.class);
                    Player1Val = Player.getText().toString();
                    i.putExtra("Name", Player1Val);
                    i.putExtra("Choice", Extra_Player);
                    startActivity(i);
                    //log function
                    Log.v("5x5Button", "Button Clicked");
                }
                //else {
                //Toast.makeText(this, "You must select a game board", Toast.LENGTH_SHORT).show();
                //}
            }
        });

    }
}
