package com.example.android.tic_tac_toechallenge;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main5x5TwoPlayerActivity extends AppCompatActivity implements View.OnClickListener{

    private final static String TAG = Main5x5TwoPlayerActivity.class.getSimpleName();
    private boolean PLAYER_X = true;

    private int TURN_COUNT = 0;

    private Button b000;
    private Button b001;
    private Button b002;
    private Button b003;
    private Button b004;

    private Button b010;
    private Button b011;
    private Button b012;
    private Button b013;
    private Button b014;

    private Button b020;
    private Button b021;
    private Button b022;
    private Button b023;
    private Button b024;

    private Button b030;
    private Button b031;
    private Button b032;
    private Button b033 ;
    private Button b034;
    private Button b040;
    private Button b041;
    private Button b042;
    private Button b043;
    private Button b044;

    private String nameVal1;
    private String nameVal2;

    private TextView player1name;
    private TextView player1score;
    private TextView player2score;

    private int p1score = 0;
    private int p2score = 0;

    private TextView diaInfo;

    private final int[][] boardStatus = new int[5][5];

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5x5_two_player);

        b000 = findViewById(R.id.bt00);
        b001 = findViewById(R.id.bt01);
        b002 = findViewById(R.id.bt02);
        b003 = findViewById(R.id.bt03);
        b004 = findViewById(R.id.bt04);

        b010 = findViewById(R.id.bt10);
        b011 = findViewById(R.id.bt11);
        b012 = findViewById(R.id.bt12);
        b013 = findViewById(R.id.bt13);
        b014 = findViewById(R.id.bt14);

        b020 = findViewById(R.id.bt20);
        b021 = findViewById(R.id.bt21);
        b022 = findViewById(R.id.bt22);
        b023 = findViewById(R.id.bt23);
        b024 = findViewById(R.id.bt24);

        b030 = findViewById(R.id.bt30);
        b031 = findViewById(R.id.bt31);
        b032 = findViewById(R.id.bt32);
        b033 = findViewById(R.id.bt33);
        b034 = findViewById(R.id.bt34);

        b040 = findViewById(R.id.bt40);
        b041 = findViewById(R.id.bt41);
        b042 = findViewById(R.id.bt42);
        b043 = findViewById(R.id.bt43);
        b044 = findViewById(R.id.bt44);


        player1name = findViewById(R.id.play1Name);
        player1score = findViewById(R.id.play1Score);
        TextView player2name = findViewById(R.id.play2Name);
        player2score = findViewById(R.id.play2Score);
        Button btReset = findViewById(R.id.restButton);
        diaInfo = findViewById(R.id.tnInfo);

        nameVal1 = getIntent().getExtras().getString("Name1");
        nameVal2 = getIntent().getExtras().getString("Name2");

        player1score.setText("" + p1score);
        player2score.setText("" + p2score);

        player1name.setText(nameVal1);
        player2name.setText(nameVal2);

        btReset.setOnClickListener(this);

        b000.setOnClickListener(this);
        b001.setOnClickListener(this);
        b002.setOnClickListener(this);
        b003.setOnClickListener(this);
        b004.setOnClickListener(this);

        b010.setOnClickListener(this);
        b011.setOnClickListener(this);
        b012.setOnClickListener(this);
        b013.setOnClickListener(this);
        b014.setOnClickListener(this);

        b020.setOnClickListener(this);
        b021.setOnClickListener(this);
        b022.setOnClickListener(this);
        b023.setOnClickListener(this);
        b024.setOnClickListener(this);

        b030.setOnClickListener(this);
        b031.setOnClickListener(this);
        b032.setOnClickListener(this);
        b033.setOnClickListener(this);
        b034.setOnClickListener(this);

        b040.setOnClickListener(this);
        b041.setOnClickListener(this);
        b042.setOnClickListener(this);
        b043.setOnClickListener(this);
        b044.setOnClickListener(this);

        initializeBoardStatus();

    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "Inside onClick");

        boolean resetButtonPressed = false;

        switch (view.getId()){
            case R.id.bt00:
                if(PLAYER_X){
                    b000.setText("X");
                    boardStatus[0][0] = 1;
                }
                else{
                    b000.setText("0");
                    boardStatus[0][0] = 0;
                }
                b000.setEnabled(false);
                break;

            case R.id.bt01:
                if(PLAYER_X){
                    b001.setText("X");
                    boardStatus[0][1] = 1;
                }
                else{
                    b001.setText("0");
                    boardStatus[0][1] = 0;
                }
                b001.setEnabled(false);
                break;

            case R.id.bt02:
                if(PLAYER_X){
                    b002.setText("X");
                    boardStatus[0][2] = 1;
                }
                else{
                    b002.setText("0");
                    boardStatus[0][2] = 0;
                }
                b002.setEnabled(false);
                break;
            case R.id.bt03:
                if(PLAYER_X){
                    b003.setText("X");
                    boardStatus[0][3] = 1;
                }
                else{
                    b003.setText("0");
                    boardStatus[0][3] = 0;
                }
                b003.setEnabled(false);
                break;
            case R.id.bt04:
                if(PLAYER_X){
                    b004.setText("X");
                    boardStatus[0][4] = 1;
                }
                else{
                    b004.setText("0");
                    boardStatus[0][4] = 0;
                }
                b004.setEnabled(false);
                break;

            case R.id.bt10:
                if(PLAYER_X){
                    b010.setText("X");
                    boardStatus[1][0] = 1;
                }
                else{
                    b010.setText("0");
                    boardStatus[1][0] = 0;
                }
                b010.setEnabled(false);
                break;

            case R.id.bt11:
                if(PLAYER_X){
                    b011.setText("X");
                    boardStatus[1][1] = 1;
                }
                else{
                    b011.setText("0");
                    boardStatus[1][1] = 0;
                }
                b011.setEnabled(false);
                break;

            case R.id.bt12:
                if(PLAYER_X){
                    b012.setText("X");
                    boardStatus[1][2] = 1;
                }
                else{
                    b012.setText("0");
                    boardStatus[1][2] = 0;
                }
                b012.setEnabled(false);
                break;

            case R.id.bt13:
                if(PLAYER_X){
                    b013.setText("X");
                    boardStatus[1][3] = 1;
                }
                else{
                    b013.setText("0");
                    boardStatus[1][3] = 0;
                }
                b013.setEnabled(false);
                break;

            case R.id.bt14:
                if(PLAYER_X){
                    b014.setText("X");
                    boardStatus[1][4] = 1;
                }
                else{
                    b014.setText("0");
                    boardStatus[1][4] = 0;
                }
                b014.setEnabled(false);
                break;

            case R.id.bt20:
                if(PLAYER_X){
                    b020.setText("X");
                    boardStatus[2][0] = 1;
                }
                else{
                    b020.setText("0");
                    boardStatus[2][0] = 0;
                }
                b020.setEnabled(false);
                break;

            case R.id.bt21:
                if(PLAYER_X){
                    b021.setText("X");
                    boardStatus[2][1] = 1;
                }
                else{
                    b021.setText("0");
                    boardStatus[2][1] = 0;
                }
                b021.setEnabled(false);
                break;

            case R.id.bt22:
                if(PLAYER_X){
                    b022.setText("X");
                    boardStatus[2][2] = 1;
                }
                else{
                    b022.setText("0");
                    boardStatus[2][2] = 0;
                }
                b022.setEnabled(false);
                break;

            case R.id.bt23:
                if(PLAYER_X){
                    b023.setText("X");
                    boardStatus[2][3] = 1;
                }
                else{
                    b023.setText("0");
                    boardStatus[2][3] = 0;
                }
                b023.setEnabled(false);
                break;

            case R.id.bt24:
                if(PLAYER_X){
                    b024.setText("X");
                    boardStatus[2][4] = 1;
                }
                else{
                    b024.setText("0");
                    boardStatus[2][4] = 0;
                }
                b024.setEnabled(false);
                break;

            case R.id.bt30:
                if(PLAYER_X){
                    b030.setText("X");
                    boardStatus[3][0] = 1;
                }
                else{
                    b030.setText("0");
                    boardStatus[3][0] = 0;
                }
                b030.setEnabled(false);
                break;

            case R.id.bt31:
                if(PLAYER_X){
                    b031.setText("X");
                    boardStatus[3][1] = 1;
                }
                else{
                    b031.setText("0");
                    boardStatus[3][1] = 0;
                }
                b031.setEnabled(false);
                break;

            case R.id.bt32:
                if(PLAYER_X){
                    b032.setText("X");
                    boardStatus[3][2] = 1;
                }
                else{
                    b032.setText("0");
                    boardStatus[3][2] = 0;
                }
                b032.setEnabled(false);
                break;

            case R.id.bt33:
                if(PLAYER_X){
                    b033.setText("X");
                    boardStatus[3][3] = 1;
                }
                else{
                    b033.setText("0");
                    boardStatus[3][3] = 0;
                }
                b033.setEnabled(false);
                break;

            case R.id.bt34:
                if(PLAYER_X){
                    b034.setText("X");
                    boardStatus[3][4] = 1;
                }
                else{
                    b034.setText("0");
                    boardStatus[3][4] = 0;
                }
                b034.setEnabled(false);
                break;

            case R.id.bt40:
                if(PLAYER_X){
                    b040.setText("X");
                    boardStatus[4][0] = 1;
                }
                else{
                    b040.setText("0");
                    boardStatus[4][0] = 0;
                }
                b040.setEnabled(false);
                break;

            case R.id.bt41:
                if(PLAYER_X){
                    b041.setText("X");
                    boardStatus[4][1] = 1;
                }
                else{
                    b041.setText("0");
                    boardStatus[4][1] = 0;
                }
                b041.setEnabled(false);
                break;

            case R.id.bt42:
                if(PLAYER_X){
                    b042.setText("X");
                    boardStatus[4][2] = 1;
                }
                else{
                    b042.setText("0");
                    boardStatus[4][2] = 0;
                }
                b042.setEnabled(false);
                break;

            case R.id.bt43:
                if(PLAYER_X){
                    b043.setText("X");
                    boardStatus[4][3] = 1;
                }
                else{
                    b043.setText("0");
                    boardStatus[4][3] = 0;
                }
                b043.setEnabled(false);
                break;

            case R.id.bt44:
                if(PLAYER_X){
                    b044.setText("X");
                    boardStatus[4][4] = 1;
                }
                else{
                    b044.setText("0");
                    boardStatus[4][4] = 0;
                }
                b044.setEnabled(false);
                break;

            case R.id.restButton:
                resetButtonPressed = true;
                break;

            default:
                break;

        }

        if(resetButtonPressed){
            resetBoard();
        }
        else{
            TURN_COUNT ++;
            PLAYER_X = !PLAYER_X;

            if(PLAYER_X){
                setInfo(nameVal1 + "'s  turn");
            }
            else {
                setInfo(nameVal2 + "'s  turn");
            }

            if(TURN_COUNT==25){
                result("Game Over. It's a Draw!");
            }

            checkWinner();
        }
    }

    @SuppressLint("SetTextI18n")
    private void checkWinner(){

        Log.d(TAG, "checkWinner");

        //Horizontal --- rows
        for(int i=0; i<5; i++){
            if(boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2] && boardStatus[i][0] == boardStatus[i][3] && boardStatus[i][0] == boardStatus[i][4]){
                if (boardStatus[i][0]==1){
                    result("Game Over. " + nameVal1 + " win!");
                    p1score = p1score + 5;
                    player1score.setText("" + p1score);
                    break;
                }
                else if (boardStatus[i][0]==0) {
                    result("Game Over. " + nameVal2 + " wins");
                    p2score = p2score + 5;
                    player2score.setText("" + p2score);
                    break;
                }
            }
        }

        //Vertical --- columns
        for(int i=0; i<5; i++){
            if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i] && boardStatus[0][i] == boardStatus[3][i] && boardStatus[0][i] == boardStatus[4][i]){
                if (boardStatus[0][i]==1){
                    result("Game Over. " + nameVal1 + " win!");
                    p1score = p1score + 5;
                    player1score.setText("" + p1score);
                    break;
                }
                else if (boardStatus[0][i]==0) {
                    result("Game Over. " + nameVal2 + " win!");
                    p2score = p2score + 5;
                    player2score.setText("" + p2score);
                    break;
                }
            }
        }

        //First diagonal
        if(boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2] && boardStatus[0][0] == boardStatus[3][3] && boardStatus[0][0] == boardStatus[4][4]){
            if (boardStatus[0][0]==1){
                result("Game Over. " + nameVal1 + " win!");
                p1score = p1score + 5;
                player1score.setText("" + p1score);
            }
            else if (boardStatus[0][0]==0) {
                result("Game Over. " + nameVal2 + " win!");
                p2score = p2score + 5;
                player2score.setText("" + p2score);
            }
        }

        //Second diagonal
        if(boardStatus[0][4] == boardStatus[1][3] && boardStatus[0][4] == boardStatus[2][2] && boardStatus[0][4] == boardStatus[3][1] && boardStatus[0][4] == boardStatus[4][0]){
            if (boardStatus[0][4]==1){
                result("Game Over. " + nameVal1 + " win!");
                p1score = p1score + 5;
                player1score.setText("" + p1score);
            }
            else if (boardStatus[0][4]==0) {
                result("Game Over. " + nameVal2 + " win!");
                p2score = p2score + 5;
                player2score.setText("" + p2score);
            }
        }
    }

    private void enableAllBoxes(boolean value){
        Log.d(TAG, "Inside enableAllBoxes");
        b000.setEnabled(value);
        b001.setEnabled(value);
        b002.setEnabled(value);
        b003.setEnabled(value);
        b004.setEnabled(value);

        b010.setEnabled(value);
        b011.setEnabled(value);
        b012.setEnabled(value);
        b013.setEnabled(value);
        b014.setEnabled(value);

        b020.setEnabled(value);
        b021.setEnabled(value);
        b022.setEnabled(value);
        b023.setEnabled(value);
        b024.setEnabled(value);

        b030.setEnabled(value);
        b031.setEnabled(value);
        b032.setEnabled(value);
        b033.setEnabled(value);
        b034.setEnabled(value);

        b040.setEnabled(value);
        b041.setEnabled(value);
        b042.setEnabled(value);
        b043.setEnabled(value);
        b044.setEnabled(value);

    }

    private void result(String winner){
        Log.d(TAG, "Inside result");

        setInfo(winner);
        enableAllBoxes(false);
    }

    private void resetBoard(){
        Log.d(TAG, "Inside resetBoard");
        b000.setText("");
        b001.setText("");
        b002.setText("");
        b003.setText("");
        b004.setText("");

        b010.setText("");
        b011.setText("");
        b012.setText("");
        b013.setText("");
        b014.setText("");

        b020.setText("");
        b021.setText("");
        b022.setText("");
        b023.setText("");
        b024.setText("");

        b030.setText("");
        b031.setText("");
        b032.setText("");
        b033.setText("");
        b034.setText("");

        b040.setText("");
        b041.setText("");
        b042.setText("");
        b043.setText("");
        b044.setText("");


        enableAllBoxes(true);

        PLAYER_X = true;
        TURN_COUNT = 0;

        initializeBoardStatus();

        setInfo("Start Again!");

    }

    private void setInfo(String text){
        diaInfo.setText(text);
    }

    private void initializeBoardStatus(){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                boardStatus[i][j] = -1;
            }
        }

    }

    public void reduceBoard(View view) {
        Intent intent = new Intent(Main5x5TwoPlayerActivity.this, MainTwoPlayerBoard3Activity.class);
        String Player1Name = player1name.getText().toString();
        String Player2Name = player1name.getText().toString();
        intent.putExtra("Score1", p1score);
        intent.putExtra("Score2", p2score);
        intent.putExtra("Value1", Player1Name);
        intent.putExtra("Value2", Player2Name);
        startActivity(intent);
    }

}

