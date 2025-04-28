package org.example;

import java.util.ArrayList;
import java.util.Random;

public class ComputerPlayer {
    private char computerChar;
    private char playerChar;
    ComputerPlayer(char computerChar, char playerChar) {
        this.computerChar = computerChar;
        this.playerChar = playerChar;
    }
    int firstMove() {
        switch(new Random().nextInt(0, 3)) {
            case 0:
                return 1;
            case 1:
                return 3;
            case 2:
                return 7;
            case 3:
                return 9;
        }
        return 0;
    }
    int secondMove(char[][] board) {
        if(board[1][1] != playerChar) {
            return 5;
        } else {
            return bestMove(board);
        }
    }
    boolean isWinningMove(char checkingChar, int r, int c, char[][] board) {
        if(board[c][(r + 1) % 3] == checkingChar &&
           board[c][(r + 2) % 3] == checkingChar) {
            return true;
        }
        if(board[(c + 1) % 3][r] == checkingChar &&
           board[(c + 2) % 3][r] == checkingChar) {
            return true;
        }
        if(r == c) {
            if(board[(c + 1) % 3][(r + 1) % 3] == checkingChar &&
               board[(c + 2) % 3][(r + 2) % 3] == checkingChar) {
                return true;
            }
        } else if(r == 2 - c) {
            if(board[(c + 1) % 3][(r + 2) % 3] == checkingChar &&
               board[(c + 2) % 3][(r + 1) % 3] == checkingChar) {
                return true;
            }
        }
        return false;
    }
    int bestMove(char[][] board) {
        ArrayList<Integer> winningMove = new ArrayList<>();
        ArrayList<Integer> blockingMove = new ArrayList<>();
        ArrayList<Integer> validMove = new ArrayList<>();
        for(int r = 0; r < 3; ++r) {
            for(int c = 0; c < 3; ++c) {
                if(board[c][r] != playerChar && board[c][r] != computerChar) {
                    int move = r * 3 + c + 1;
                    validMove.add(move);
                    if(isWinningMove(computerChar, r, c, board)) {
                        winningMove.add(move);
                    }
                    if(isWinningMove(playerChar, r, c, board)) {
                        blockingMove.add(move);
                    }
                }
            }
        }
        if(!winningMove.isEmpty()) {
            return winningMove.get(new Random().nextInt(0, winningMove.size()));
        }
        if(!blockingMove.isEmpty()) {
            return blockingMove.get(new Random().nextInt(0, blockingMove.size()));
        }
        if(!validMove.isEmpty()) {
            return validMove.get(new Random().nextInt(0, validMove.size()));
        }
        return 0;
    }
}
