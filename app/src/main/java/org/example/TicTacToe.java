package org.example;

public class TicTacToe {
    static final char PLAYER1 = 'X';
    static final char PLAYER2 = 'O';
    private int size;
    private int currPlayer;
    private char[][] board;
    public TicTacToe() {
        size = 3;
        currPlayer = 1;
        board = new char[size][size];
        reset();
    }
    public void reset(int firstPlayer) {
        currPlayer = firstPlayer;
        for(int c = 0; c < size; ++c) {
            for(int r = 0; r < size; ++r) {
                board[c][r] = (char) ('1' + r * 3 + c);
            }
        }
    }
    public void reset() {
        reset(1);
    }
    public void printBoard() {
        for(int r = 0; r < size; ++r) {
            if(r != 0) {
                System.out.println("-----+-----+-----");
            }
            System.out.println("  " + board[0][r] + "  |  " + board[1][r] + "  |  " + board[2][r] + "  ");
        }
    }
    public String stringBoard() {
        String str = "";
        for(int r = 0; r < size; ++r) {
            if(r != 0) {
                str += "-----+-----+-----\n";
            }
            str += "  " + board[0][r] + "  |  " + board[1][r] + "  |  " + board[2][r] + "  \n";
        }
        return str;
    }
    public boolean move(int spot) {
        if(spot < 1 || 9 < spot) {
            return false;
        }
        spot--;
        int r = spot / size;
        int c = spot % size;
        if(board[c][r] == PLAYER1 || board[c][r] == PLAYER2) {
            return false;
        }
        if(currPlayer == 1) {
            board[c][r] = PLAYER1;
            currPlayer = 2;
        } else if(currPlayer == 2) {
            board[c][r] = PLAYER2;
            currPlayer = 1;
        }
        return true;
    }
    public boolean isPlayerWin(char player) {
        for(int i = 0; i < size; ++i) {
            if(board[i][0] == player &&
               board[i][1] == player &&
               board[i][2] == player) {
                return true;
            }
            if(board[0][i] == player &&
               board[1][i] == player &&
               board[2][i] == player) {
                return true;
            }
        }
        if(board[0][0] == player &&
           board[1][1] == player &&
           board[2][2] == player) {
            return true;
        }
        if(board[2][0] == player &&
           board[1][1] == player &&
           board[0][2] == player) {
            return true;
        }
        return false;
    }
    public boolean fullBoard() {
        for(int r = 0; r < size; ++r) {
            for(int c = 0; c < size; ++c) {
                if(board[c][r] != PLAYER1 &&
                   board[c][r] != PLAYER2) {
                    return false;
                }
            }
        }
        return true;
    }
    public int winningPlayer() {
        if(isPlayerWin(PLAYER1)) {
            return 1;
        }
        if(isPlayerWin(PLAYER2)) {
            return 2;
        }
        if(fullBoard()) {
            return 0;
        } else {
            return -1;
        }
    }
    public int getCurrPlayer() {
        return currPlayer;
    }
}

/*


+ PLAYER1 : char = 'X'
+ PLAYER2 : char = 'O'
- size : int
- currPlayer : int
- board : char[][]

+ reset() : void
+ printBoard() : void
+ stringBoard() : String
+ move(int) : boolean
+ isPlayerWin(char) : boolean
+ fullBoard() : boolean
+ winningPlayer() : int
+ getCurrPlayer() : int



*/