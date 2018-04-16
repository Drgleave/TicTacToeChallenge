package com.example.android.tic_tac_toechallenge;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Main3SinglePlayerActivity extends AppCompatActivity {

    private int[][] c;
    private int i;
    private int j;
    // --Commented out by Inspection (4/16/2018 1:26 AM):int k = 0;
    private Button[][] b;
    private TextView textView;
    private TextView playerName;
    private TextView player1Score;
    private TextView player2Score;
    private int playerScore = 0;
    private int computerScore = 0;
    private AI ai;
    private String PlayerValue;
    private int user;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3_single_player);
        player1Score = findViewById(R.id.pScore);
        player2Score = findViewById(R.id.cScore);
        playerScore = getIntent().getExtras().getInt("Score1");
        computerScore = getIntent().getExtras().getInt("Score2");
        player1Score.setText("" + playerScore);
        player2Score.setText("" + computerScore);
        user = getIntent().getExtras().getInt("Choice" );
        PlayerValue = getIntent().getExtras().getString("Name");
        setBoard();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem item = menu.add("Whole New Game!");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        setBoard();
        return true;
    }


    /**
     * Method to set up game board
     */
    @SuppressLint("SetTextI18n")
    private void setBoard() {
        ai = new AI();
        b = new Button[4][4];
        c = new int[4][4];


        textView = findViewById(R.id.dialogue);
        playerName = findViewById(R.id.pName);

        playerName.setText(PlayerValue);




        b[1][3] = findViewById(R.id.one);
        b[1][2] = findViewById(R.id.two);
        b[1][1] = findViewById(R.id.three);


        b[2][3] = findViewById(R.id.four);
        b[2][2] = findViewById(R.id.five);
        b[2][1] = findViewById(R.id.six);


        b[3][3] = findViewById(R.id.seven);
        b[3][2] = findViewById(R.id.eight);
        b[3][1] = findViewById(R.id.nine);

        for (i = 1; i <= 3; i++) {
            for (j = 1; j <= 3; j++)
                c[i][j] = 2;
        }

        textView.setText("Start first.");


        for (i = 1; i <= 3; i++) {
            for (j = 1; j <= 3; j++) {
                b[i][j].setOnClickListener(new MyClickListener(i, j));
                if (!b[i][j].isEnabled()) {
                    b[i][j].setText(" ");
                    b[i][j].setEnabled(true);
                }
            }
        }
    }


    class MyClickListener implements View.OnClickListener {
        final int x;
        final int y;


        public MyClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public void onClick(View view) {
            if (b[x][y].isEnabled()) {
                b[x][y].setEnabled(false);
                if (user == 1) {
                b[x][y].setText("O");
                } else if (user == 2) {
                    b[x][y].setText("X");
                }
                else {
                    b[x][y].setText("X");
                }
                c[x][y] = 0;
                textView.setText("");
                if (!checkBoard()) {
                    ai.takeTurn();
                }
            }
        }
    }

    /**
     * Method to act as artificial intelligence
     */
    private class AI {
        public void takeTurn() {
            if (c[1][1] == 2 &&
                    ((c[1][2] == 0 && c[1][3] == 0) ||
                            (c[2][2] == 0 && c[3][3] == 0) ||
                            (c[2][1] == 0 && c[3][1] == 0))) {
                markSquare(1, 1);
            } else if (c[1][2] == 2 &&
                    ((c[2][2] == 0 && c[3][2] == 0) ||
                            (c[1][1] == 0 && c[1][3] == 0))) {
                markSquare(1, 2);
            } else if (c[1][3] == 2 &&
                    ((c[1][1] == 0 && c[1][2] == 0) ||
                            (c[3][1] == 0 && c[2][2] == 0) ||
                            (c[2][3] == 0 && c[3][3] == 0))) {
                markSquare(1, 3);
            } else if (c[2][1] == 2 &&
                    ((c[2][2] == 0 && c[2][3] == 0) ||
                            (c[1][1] == 0 && c[3][1] == 0))) {
                markSquare(2, 1);
            } else if (c[2][2] == 2 &&
                    ((c[1][1] == 0 && c[3][3] == 0) ||
                            (c[1][2] == 0 && c[3][2] == 0) ||
                            (c[3][1] == 0 && c[1][3] == 0) ||
                            (c[2][1] == 0 && c[2][3] == 0))) {
                markSquare(2, 2);
            } else if (c[2][3] == 2 &&
                    ((c[2][1] == 0 && c[2][2] == 0) ||
                            (c[1][3] == 0 && c[3][3] == 0))) {
                markSquare(2, 3);
            } else if (c[3][1] == 2 &&
                    ((c[1][1] == 0 && c[2][1] == 0) ||
                            (c[3][2] == 0 && c[3][3] == 0) ||
                            (c[2][2] == 0 && c[1][3] == 0))) {
                markSquare(3, 1);
            } else if (c[3][2] == 2 &&
                    ((c[1][2] == 0 && c[2][2] == 0) ||
                            (c[3][1] == 0 && c[3][3] == 0))) {
                markSquare(3, 2);
            } else if (c[3][3] == 2 &&
                    ((c[1][1] == 0 && c[2][2] == 0) ||
                            (c[1][3] == 0 && c[2][3] == 0) ||
                            (c[3][1] == 0 && c[3][2] == 0))) {
                markSquare(3, 3);
            } else {
                Random rand = new Random();

                int a = rand.nextInt(4);
                int b = rand.nextInt(4);
                while (a == 0 || b == 0 || c[a][b] != 2) {
                    a = rand.nextInt(4);
                    b = rand.nextInt(4);
                }
                markSquare(a, b);
            }
        }


        private void markSquare(int x, int y) {
            b[x][y].setEnabled(false);
            if (user == 1){
            b[x][y].setText("X");
            }
            else if (user == 2){
                b[x][y].setText("O");
            }
            else {
                b[x][y].setText("O");
            }
            c[x][y] = 1;
            checkBoard();
        }
    }

    /**
     * Method to check the board for winner
     */
    @SuppressLint("SetTextI18n")
    private boolean checkBoard() {
        boolean gameOver = false;
        if ((c[1][1] == 0 && c[2][2] == 0 && c[3][3] == 0)
                || (c[1][3] == 0 && c[2][2] == 0 && c[3][1] == 0)
                || (c[1][2] == 0 && c[2][2] == 0 && c[3][2] == 0)
                || (c[1][3] == 0 && c[2][3] == 0 && c[3][3] == 0)
                || (c[1][1] == 0 && c[1][2] == 0 && c[1][3] == 0)
                || (c[2][1] == 0 && c[2][2] == 0 && c[2][3] == 0)
                || (c[3][1] == 0 && c[3][2] == 0 && c[3][3] == 0)
                || (c[1][1] == 0 && c[2][1] == 0 && c[3][1] == 0)) {
            textView.setText("Game over. "+ PlayerValue + " wins!");
           playerScore = playerScore + 3;
            display(playerScore);
            enableAllBoxes(false);
            gameOver = true;
        } else if ((c[1][1] == 1 && c[2][2] == 1 && c[3][3] == 1)
                || (c[1][3] == 1 && c[2][2] == 1 && c[3][1] == 1)
                || (c[1][2] == 1 && c[2][2] == 1 && c[3][2] == 1)
                || (c[1][3] == 1 && c[2][3] == 1 && c[3][3] == 1)
                || (c[1][1] == 1 && c[1][2] == 1 && c[1][3] == 1)
                || (c[2][1] == 1 && c[2][2] == 1 && c[2][3] == 1)
                || (c[3][1] == 1 && c[3][2] == 1 && c[3][3] == 1)
                || (c[1][1] == 1 && c[2][1] == 1 && c[3][1] == 1)) {
            textView.setText("Game over. Computer wins!");
            computerScore = computerScore + 3;
            displayCom(computerScore);
            enableAllBoxes(false);
            gameOver = true;
        } else {
            boolean empty = false;
            for (i = 1; i <= 3; i++) {
                for (j = 1; j <= 3; j++) {
                    if (c[i][j] == 2) {
                        empty = true;
                        break;
                    }
                }
            }
            if (!empty) {
                gameOver = true;
                textView.setText("Game over. It's a draw!");
                enableAllBoxes(false);
            }
        }
        return gameOver;
    }
    /**
     * Reset Button action to reset the game board size without changing scores.
     */
    @SuppressLint("SetTextI18n")
    public void resetBoard(View view) {

        b[1][3].setText("");
        b[1][2].setText("");
        b[1][1].setText("");


        b[2][3].setText("");
        b[2][2].setText("");
        b[2][1].setText("");


        b[3][3].setText("");
        b[3][2].setText("");
        b[3][1].setText("");

        enableAllBoxes(true);
        setBoard();
        textView.setText("Click to start!.");
    }
    /**
     * Method to enable or disable buttons on game board.
     */
    private void enableAllBoxes(boolean value){

        b[1][3].setEnabled(value);
        b[1][2].setEnabled(value);
        b[1][1].setEnabled(value);


        b[2][3].setEnabled(value);
        b[2][2].setEnabled(value);
        b[2][1].setEnabled(value);


        b[3][3].setEnabled(value);
        b[3][2].setEnabled(value);
        b[3][1].setEnabled(value);
    }
    /**
     * 5x5 Button action to increase the board size and transfer game progress.
     */
    public void IncreaseBoard(View view) {
        Intent intent = new Intent(Main3SinglePlayerActivity.this, Main5SinglePlayerActivity.class);
        String PlayerName = playerName.getText().toString();
        intent.putExtra("Score1", playerScore);
        intent.putExtra("Score2", computerScore);
        intent.putExtra("Name", PlayerName);
        intent.putExtra("Choice", user);
        startActivity(intent);
    }
    /**
     * This method displays the given player score on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void display(int number) {
        player1Score.setText("" + number);
    }
    /**
     * This method displays the given computer score on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void displayCom(int number) {
        player2Score.setText("" + number);
    }

}
