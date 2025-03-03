package org.example;

public class TicTacToe {
    private int rs, cs;
    private int currPlayer;
    private char[][] board;
    public TicTacToe() {
        rs = 3;
        cs = 3;
        currPlayer = 1;
        board = new char[cs][rs];
        reset();
    }
    void reset() {
        for(int c = 0; c < cs; ++c) {
            for(int r = 0; r < rs; ++r) {
                board[c][r] = (char) ('1' + r * 3 + c);
            }
        }
    }
    void printBoard() {
        for(int r = 0; r < rs; ++r) {
            if(r != 0) {
                System.out.println("-----+-----+-----");
            }
            System.out.println("  " + board[0][r] + "  |  " + board[1][r] + "  |  " + board[2][r] + "  ");
        }
    }
    String stringBoard() {
        String str = "";
        for(int r = 0; r < rs; ++r) {
            if(r != 0) {
                str += "-----+-----+-----\n";
            }
            str += "  " + board[0][r] + "  |  " + board[1][r] + "  |  " + board[2][r] + "  \n";
        }
        return str;
    }
    boolean move(int spot) {
        if(spot < 1 || rs * cs < spot) {
            return false;
        }
        spot--;
        int r = spot / rs;
        int c = spot % cs;
        if(board[c][r] == 'X' || board[c][r] == 'O') {
            return false;
        }
        if(currPlayer == 1) {
            board[c][r] = 'X';
            currPlayer = 2;
        } else if(currPlayer == 2) {
            board[c][r] = 'O';
            currPlayer = 1;
        }
        return true;
    }
    int winningPlayer() {
        int player = 0;
        boolean winner = false;
        char currChar = ' ';
        for(int c = 0; c < cs && !winner; ++c) {
            winner = true;
            currChar = board[c][0];
            for(int r = 1; r < rs && winner; ++r) {
                if(currChar != board[c][r]) {
                    winner = false;
                }
            }
        }
        for(int r = 0; r < rs && !winner; ++r) {
            winner = true;
            currChar = board[0][r];
            for(int c = 1; c < cs && winner; ++c) {
                if(currChar != board[c][r]) {
                    winner = false;
                }
            }
        }
        if(!winner) {
            winner = true;
            currChar = board[0][0];
            for(int i = 1; i < rs; ++i) {
                if(currChar != board[i][i]) {
                    winner = false;
                }
            }
        }
        if(!winner) {
            winner = true;
            currChar = board[cs - 1][0];
            for(int i = 1; i < rs; ++i) {
                if(currChar != board[cs - i - 1][i]) {
                    winner = false;
                }
            }
        }
        if(winner) {
            if(currChar == 'X') {
                player = 1;
            } else if(currChar == 'O') {
                player = 2;
            }
        } else {
            for(int c = 0; c < cs; ++c) {
                for(int r = 0; r < rs; ++r) {
                    if(board[c][r] != 'X' && board[c][r] != 'O') {
                        player = -1;
                    }
                }
            }
        }
        return player;
    }
    int getCurrPlayer() {
        return currPlayer;
    }
}
