package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ComputerPlayerTest {
    ComputerPlayer computerPlayer;
    @BeforeEach
    void init() {
        computerPlayer = new ComputerPlayer('X', 'O');
    }

    @Test
    void firstMove() {
        for(int i = 0; i < 100; ++i) {
            int move = computerPlayer.firstMove();
            Assertions.assertTrue(move == 1 || move == 3 || move == 7 || move == 9);
        }
    }

    @Test
    void secondMoveEmpty() {
        char[][] blankBoard = {{'1', '4', '7'}, {'2', '5', '8'}, {'3', '6', '9'}};
        Assertions.assertEquals(5, computerPlayer.secondMove(blankBoard));
    }

    @Test
    void secondMoveFull() {
        char[][] centerBoard = {{'1', '4', '7'}, {'2', 'O', '8'}, {'3', '6', '9'}};
        Assertions.assertTrue(5 != computerPlayer.secondMove(centerBoard));
    }

    @Test
    void blockingMove() {
        char[][] playBoard = {{'O', '4', '7'},
                              {'2', 'O', '8'},
                              {'3', '6', '9'}};
        Assertions.assertEquals(9, computerPlayer.bestMove(playBoard));
    }

    @Test
    void winningMove() {
        char[][] playBoard = {{'O', '4', 'X'},
                              {'2', 'X', '8'},
                              {'3', '6', '9'}};
        Assertions.assertEquals(3, computerPlayer.bestMove(playBoard));
    }
}
