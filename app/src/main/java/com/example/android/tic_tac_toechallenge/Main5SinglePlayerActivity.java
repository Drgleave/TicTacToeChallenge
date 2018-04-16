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

public class Main5SinglePlayerActivity extends AppCompatActivity {

    private int[][] c;
    private int i;
    private int j;
    // --Commented out by Inspection (4/16/2018 1:26 AM):int k = 0;
    private Button[][] b;
    private TextView winView;
    private TextView userName;
    private TextView user1Score;
    private TextView user2Score;
    private int userScore = 0;
    private int aiScore = 0;
    private AI ai;
    private String userValue;
    private int player;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5_single_player);
        user1Score = findViewById(R.id.plScore);
        user2Score = findViewById(R.id.cpScore);
        userScore = getIntent().getExtras().getInt("Score1");
        aiScore = getIntent().getExtras().getInt("Score2");
        user1Score.setText("" + userScore);
        user2Score.setText("" + aiScore);
        player = getIntent().getExtras().getInt("Choice" );
        userValue = getIntent().getExtras().getString("Name");

        setBoard();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem item = menu.add("New Game");
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
        b = new Button[6][6];
        c = new int[6][6];


        winView = findViewById(R.id.winInfo);
        userName = findViewById(R.id.plName);
        userName.setText(userValue);




        b[1][5] = findViewById(R.id.but00);
        b[1][4] = findViewById(R.id.but01);
        b[1][3] = findViewById(R.id.but02);
        b[1][2] = findViewById(R.id.but03);
        b[1][1] = findViewById(R.id.but04);


        b[2][5] = findViewById(R.id.but10);
        b[2][4] = findViewById(R.id.but11);
        b[2][3] = findViewById(R.id.but12);
        b[2][2] = findViewById(R.id.but13);
        b[2][1] = findViewById(R.id.but14);


        b[3][5] = findViewById(R.id.but20);
        b[3][4] = findViewById(R.id.but21);
        b[3][3] = findViewById(R.id.but22);
        b[3][2] = findViewById(R.id.but23);
        b[3][1] = findViewById(R.id.but24);


        b[4][5] = findViewById(R.id.but30);
        b[4][4] = findViewById(R.id.but31);
        b[4][3] = findViewById(R.id.but32);
        b[4][2] = findViewById(R.id.but33);
        b[4][1] = findViewById(R.id.but34);


        b[5][5] = findViewById(R.id.but40);
        b[5][4] = findViewById(R.id.but41);
        b[5][3] = findViewById(R.id.but42);
        b[5][2] = findViewById(R.id.but43);
        b[5][1] = findViewById(R.id.but44);

        for (i = 1; i <= 5; i++) {
            for (j = 1; j <= 5; j++)
                c[i][j] = 2;
        }

        winView.setText("Start first!");


        for (i = 1; i <= 5; i++) {
            for (j = 1; j <= 5; j++) {
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
                if (player == 1) {
                    b[x][y].setText("O");
                } else if (player == 2) {
                    b[x][y].setText("X");
                }
                else {
                    b[x][y].setText("X");
                }
                c[x][y] = 0;
                winView.setText("");
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
                    ((c[1][2] == 0 && c[1][3] == 0 && c[1][4] == 0 && c[1][5]==0) ||
                            (c[2][2] == 0 && c[3][3] == 0 && c[4][4] == 0 && c[5][5] ==0) ||
                            (c[2][1] == 0 && c[3][1] == 0 && c[4][1] ==0 && c[5][1] == 0))) {
                markSquare(1, 1);
            } else if (c[1][2] == 2 &&
                    ((c[2][2] == 0 && c[3][2] == 0 && c[4][2] == 0 && c[5][2] == 0) ||
                            (c[1][1] == 0 && c[1][3] == 0 && c[1][4] == 0 && c[1][5] == 0))) {
                markSquare(1, 2);
            } else if (c[1][3] == 2 &&
                    ((c[1][1] == 0 && c[1][2] == 0 && c[1][4] == 0 && c[1][5] == 0) ||
                            (c[2][3] == 0 && c[3][3] == 0 && c[4][3] ==0 && c[5][3] == 0))) {
                markSquare(1, 3);
            } else if (c[1][4] == 2 &&
                    ((c[1][1] == 0 && c[1][2] == 0 && c[1][3] == 0 && c[1][5] == 0) ||
                            (c[2][4] == 0 && c[3][4] == 0 && c[4][4] == 0 && c[5][4] == 0))) {
                markSquare(1, 4);
            } else if (c[1][5] == 2 &&
                    ((c[1][1] == 0 && c[1][2] == 0 && c[1][3] == 0 && c[1][4] == 0) ||
                            (c[2][5] == 0 && c[3][5] == 0 && c[4][5] == 0 && c[5][5] == 0) ||
                            (c[2][4] == 0 && c[3][3] == 0 && c[4][2] == 0 && c[5][1] == 0))) {
                markSquare(1, 5);
            } else if (c[2][1] == 2 &&
                    ((c[2][2] == 0 && c[2][3] == 0 && c[2][4] == 0 && c[2][5] == 0) ||
                            (c[1][1] == 0 && c[3][1] == 0 && c[4][1] == 0 && c[5][1] == 0))) {
                markSquare(2, 1);
            } else if (c[2][2] == 2 &&
                    ((c[2][1] == 0 && c[2][3] == 0 && c[2][4] == 0 && c[2][5] == 0) ||
                            (c[1][2] == 0 && c[3][2] == 0 && c[4][2] == 0 && c[5][2] == 0) ||
                            (c[1][1] == 0 && c[3][3] == 0 && c[4][4] == 0 && c[5][5] == 0))) {
                markSquare(2, 2);
            } else if (c[2][3] == 2 &&
                    ((c[2][1] == 0 && c[2][2] == 0 && c[2][4] == 0 && c[2][5] == 0) ||
                            (c[1][3] == 0 && c[3][3] == 0 && c[4][3] == 0 && c[5][3] == 0))) {
                markSquare(2, 3);
            } else if (c[2][4] == 2 &&
                    ((c[2][1] == 0 && c[2][2] == 0 && c[2][3] == 0 && c[2][5] == 0) ||
                            (c[1][4] == 0 && c[3][4] == 0  && c[4][4] == 0 && c[5][4] == 0) ||
                            (c[1][5] == 0 && c[3][3] == 0  && c[4][2] == 0 && c[5][1] == 0))) {
                markSquare(2, 4);
            } else if (c[2][5] == 2 &&
                    ((c[2][1] == 0 && c[2][2] == 0 && c[2][3] == 0 && c[2][4] == 0) ||
                            (c[1][5] == 0 && c[3][5] == 0  && c[4][5] == 0 && c[5][5] == 0))) {
                markSquare(2, 5);
            } else if (c[3][1] == 2 &&
                    ((c[1][1] == 0 && c[2][1] == 0 && c[4][1] == 0 && c[5][1] == 0) ||
                            (c[3][2] == 0 && c[3][3] == 0 && c[3][4] == 0 && c[3][5] == 0))) {
                markSquare(3, 1);
            } else if (c[3][2] == 2 &&
                    ((c[1][2] == 0 && c[2][2] == 0 && c[4][2] == 0 && c[5][2] == 0) ||
                            (c[3][1] == 0 && c[3][3] == 0 && c[3][4] == 0 && c[3][5] == 0))) {
                markSquare(3, 2);
            } else if (c[3][3] == 2 &&
                    ((c[1][1] == 0 && c[2][2] == 0 && c[4][4] == 0 && c[5][5] == 0) ||
                            (c[1][3] == 0 && c[2][3] == 0 && c[4][3] == 0 && c[5][3] == 0) ||
                            (c[3][1] == 0 && c[3][2] == 0 && c[3][4] == 0 && c[3][5] == 0) ||
                            (c[1][5] == 0 && c[2][4] == 0 && c[4][2] == 0 && c[5][1] == 0))) {
                markSquare(3, 3);
            } else if (c[3][4] == 2 &&
                    ((c[1][4] == 0 && c[2][4] == 0 && c[4][4] == 0 && c[5][4] == 0) ||
                            (c[3][1] == 0 && c[3][2] == 0 && c[3][3] == 0 && c[3][5] == 0))) {
                markSquare(3, 4);
            } else if (c[3][5] == 2 &&
                    ((c[1][5] == 0 && c[2][5] == 0 && c[4][5] == 0 && c[5][5] == 0) ||
                            (c[3][1] == 0 && c[3][2] == 0 && c[3][3] == 0 && c[3][4] == 0))) {
                markSquare(3, 5);
            } else if (c[4][1] == 2 &&
                    ((c[1][1] == 0 && c[2][1] == 0 && c[3][1] == 0 && c[5][1] == 0) ||
                            (c[4][2] == 0 && c[4][3] == 0 && c[4][4] == 0 && c[4][5] == 0))) {
                markSquare(4, 1);
            } else if (c[4][2] == 2 &&
                    ((c[1][2] == 0 && c[2][2] == 0 && c[3][2] == 0 && c[5][2] == 0) ||
                            (c[4][1] == 0 && c[4][3] == 0 && c[4][4] == 0 && c[4][5] == 0)||
                            (c[1][5] == 0 && c[2][4] == 0 && c[3][3] == 0 && c[5][1] == 0))) {
                markSquare(4, 2);
            } else if (c[4][3] == 2 &&
                    ((c[1][3] == 0 && c[2][3] == 0 && c[3][3] == 0 && c[5][3] == 0) ||
                            (c[4][1] == 0 && c[4][2] == 0 && c[4][4] == 0 && c[4][5] == 0))) {
                markSquare(4, 3);
            } else if (c[4][4] == 2 &&
                    ((c[1][4] == 0 && c[2][4] == 0 && c[4][4] == 0 && c[5][4] == 0) ||
                            (c[4][1] == 0 && c[4][2] == 0 && c[4][3] == 0 && c[4][5] == 0) ||
                            (c[1][1] == 0 && c[2][2] == 0 && c[3][3] == 0 && c[5][5] == 0))) {
                markSquare(4, 4);
            } else if (c[4][5] == 2 &&
                    ((c[1][5] == 0 && c[2][5] == 0 && c[3][5] == 0 && c[5][5] == 0) ||
                            (c[4][1] == 0 && c[4][2] == 0 && c[4][3] == 0 && c[4][4] == 0))) {
                markSquare(4, 5);
            } else if (c[5][1] == 2 &&
                    ((c[5][2] == 0 && c[5][3] == 0 && c[5][4] == 0 && c[5][5]==0) ||
                            (c[4][2] == 0 && c[3][3] == 0 && c[2][4] == 0 && c[1][5] ==0) ||
                            (c[2][1] == 0 && c[3][1] == 0 && c[4][1] ==0 && c[1][1] == 0))) {
                markSquare(5, 1);
            } else if (c[5][2] == 2 &&
                    ((c[2][2] == 0 && c[3][2] == 0 && c[4][2] == 0 && c[1][2] == 0) ||
                            (c[5][1] == 0 && c[5][3] == 0 && c[5][4] == 0 && c[5][5] == 0))) {
                markSquare(5, 2);
            } else if (c[5][3] == 2 &&
                    ((c[5][1] == 0 && c[5][2] == 0 && c[5][4] == 0 && c[5][5] == 0) ||
                            (c[1][3] == 0 && c[2][3] == 0 && c[3][3] ==0 && c[4][3] == 0))) {
                markSquare(5, 3);
            } else if (c[5][4] == 2 &&
                    ((c[5][1] == 0 && c[5][2] == 0 && c[5][3] == 0 && c[5][5] == 0) ||
                            (c[2][4] == 0 && c[3][4] == 0 && c[4][4] == 0 && c[1][4] == 0))) {
                markSquare(5, 4);
            } else if (c[5][5] == 2 &&
                    ((c[5][1] == 0 && c[5][2] == 0 && c[5][3] == 0 && c[5][4] == 0) ||
                            (c[2][5] == 0 && c[3][5] == 0 && c[4][5] == 0 && c[1][5] == 0) ||
                            (c[4][4] == 0 && c[3][3] == 0 && c[2][2] == 0 && c[1][1] == 0))) {
                markSquare(5, 5);
            } else {
                Random rand = new Random();

                int a = rand.nextInt(6);
                int b = rand.nextInt(6);
                while (a == 0 || b == 0 || c[a][b] != 2) {
                    a = rand.nextInt(6);
                    b = rand.nextInt(6);
                }
                markSquare(a, b);
            }
        }


        private void markSquare(int x, int y) {
            b[x][y].setEnabled(false);
            if (player == 1){
                b[x][y].setText("X");
            }
            else if (player == 2){
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
     * Method to check the board for winners
     */
    @SuppressLint("SetTextI18n")
    private boolean checkBoard() {
        boolean gameOver = false;
        if ((c[1][1] == 0 && c[2][2] == 0 && c[3][3] == 0 && c[4][4] == 0 && c[5][5] ==0)
                || (c[1][5] == 0 && c[2][4] == 0 && c[3][3] == 0 && c[4][2] == 0 && c[5][1] == 0)
                || (c[1][1] == 0 && c[2][1] == 0 && c[3][1] == 0 && c[4][1] == 0 && c[5][1] == 0)
                || (c[1][2] == 0 && c[2][2] == 0 && c[3][2] == 0 && c[4][2] == 0 && c[5][2] == 0)
                || (c[1][3] == 0 && c[2][3] == 0 && c[3][3] == 0 && c[4][3] == 0 && c[5][3] == 0)
                || (c[1][4] == 0 && c[2][4] == 0 && c[3][4] == 0 && c[4][4] == 0 && c[5][4] == 0)
                || (c[1][5] == 0 && c[2][5] == 0 && c[3][5] == 0 && c[4][5] == 0 && c[5][5] == 0)
                || (c[1][5] == 0 && c[1][4] == 0 && c[1][3] == 0 && c[1][2] == 0 && c[1][1] == 0)
                || (c[2][5] == 0 && c[2][4] == 0 && c[2][3] == 0 && c[2][2] == 0 && c[2][1] == 0)
                || (c[3][5] == 0 && c[3][4] == 0 && c[3][3] == 0 && c[3][2] == 0 && c[3][1] == 0)
                || (c[4][5] == 0 && c[4][4] == 0 && c[4][3] == 0 && c[4][2] == 0 && c[4][1] == 0)
                || (c[5][5] == 0 && c[5][4] == 0 && c[5][3] == 0 && c[5][2] == 0 && c[5][1] == 0)) {
            winView.setText("Game over. "+ userValue + " wins!");
            userScore = userScore + 5;
            display(userScore);
            enableAllBoxes(false);
            gameOver = true;
        } else if ((c[1][1] == 1 && c[2][2] == 1 && c[3][3] == 1 && c[4][4] == 1 && c[5][5] == 1)
                || (c[1][5] == 1 && c[2][4] == 1 && c[3][3] == 1 && c[4][2] == 1 && c[5][1] == 1)
                || (c[1][1] == 1 && c[2][1] == 1 && c[3][1] == 1 && c[4][1] == 1 && c[5][1] == 1)
                || (c[1][2] == 1 && c[2][2] == 1 && c[3][2] == 1 && c[4][2] == 1 && c[5][2] == 1)
                || (c[1][3] == 1 && c[2][3] == 1 && c[3][3] == 1 && c[4][3] == 1 && c[5][3] == 1)
                || (c[1][4] == 1 && c[2][4] == 1 && c[3][4] == 1 && c[4][4] == 1 && c[5][4] == 1)
                || (c[1][5] == 1 && c[2][5] == 1 && c[3][5] == 1 && c[4][5] == 1 && c[5][5] == 1)
                || (c[1][5] == 1 && c[1][4] == 1 && c[1][3] == 1 && c[1][2] == 1 && c[1][1] == 1)
                || (c[2][5] == 1 && c[2][4] == 1 && c[2][3] == 1 && c[2][2] == 1 && c[2][1] == 1)
                || (c[3][5] == 1 && c[3][4] == 1 && c[3][3] == 1 && c[3][2] == 1 && c[3][1] == 1)
                || (c[4][5] == 1 && c[4][4] == 1 && c[4][3] == 1 && c[4][2] == 1 && c[4][1] == 1)
                || (c[5][5] == 1 && c[5][4] == 1 && c[5][3] == 1 && c[5][2] == 1 && c[5][1] == 1)) {
            winView.setText("Game over. Computer wins!");
            aiScore = aiScore + 5;
            displayCom(aiScore);
            gameOver = true;
            enableAllBoxes(false);
        } else {
            boolean empty = false;
            for (i = 1; i <= 5; i++) {
                for (j = 1; j <= 5; j++) {
                    if (c[i][j] == 2) {
                        empty = true;
                        break;
                    }
                }
            }
            if (!empty) {
                gameOver = true;
                winView.setText("Game over. It's a draw!");
                enableAllBoxes(false);
            }
        }
        return gameOver;
    }
    /**
     * Method to reset game board without changing scores
     */
    @SuppressLint("SetTextI18n")
    public void resetGame(View view) {

        b[1][5].setText("");
        b[1][4].setText("");
        b[1][3].setText("");
        b[1][2].setText("");
        b[1][1].setText("");


        b[2][5].setText("");
        b[2][4].setText("");
        b[2][3].setText("");
        b[2][2].setText("");
        b[2][1].setText("");


        b[3][5].setText("");
        b[3][4].setText("");
        b[3][3].setText("");
        b[3][2].setText("");
        b[3][1].setText("");


        b[4][5].setText("");
        b[4][4].setText("");
        b[4][3].setText("");
        b[4][2].setText("");
        b[4][1].setText("");


        b[5][5].setText("");
        b[5][4].setText("");
        b[5][3].setText("");
        b[5][2].setText("");
        b[5][1].setText("");


        enableAllBoxes(true);
        setBoard();
        winView.setText("Click to start!");
    }

    /**
     * Method to enable or disable game buttons
     */
    private void enableAllBoxes(boolean value){

        b[1][5].setEnabled(value);
        b[1][4].setEnabled(value);
        b[1][3].setEnabled(value);
        b[1][2].setEnabled(value);
        b[1][1].setEnabled(value);


        b[2][5].setEnabled(value);
        b[2][4].setEnabled(value);
        b[2][3].setEnabled(value);
        b[2][2].setEnabled(value);
        b[2][1].setEnabled(value);


        b[3][5].setEnabled(value);
        b[3][4].setEnabled(value);
        b[3][3].setEnabled(value);
        b[3][2].setEnabled(value);
        b[3][1].setEnabled(value);


        b[4][5].setEnabled(value);
        b[4][4].setEnabled(value);
        b[4][3].setEnabled(value);
        b[4][2].setEnabled(value);
        b[4][1].setEnabled(value);


        b[5][5].setEnabled(value);
        b[5][4].setEnabled(value);
        b[5][3].setEnabled(value);
        b[5][2].setEnabled(value);
        b[5][1].setEnabled(value);

    }
    /**
     * 5x5 Button action to reduce the board size and transfer game progress.
     */
    public void ReduceBoard(View view) {
        Intent intent = new Intent(Main5SinglePlayerActivity.this, Main3SinglePlayerActivity.class);
        String PlayerName = userName.getText().toString();
        intent.putExtra("Score1", userScore);
        intent.putExtra("Score2", aiScore);
        intent.putExtra("Name", PlayerName);
        intent.putExtra("Choice", player);
        startActivity(intent);
    }
    /**
     * This method displays the given player score on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void display(int number) {
        user1Score.setText("" + number);
    }
    /**
     * This method displays the given computer score on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void displayCom(int number) {
        user2Score.setText("" + number);
    }

}

