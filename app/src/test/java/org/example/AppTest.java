package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  static TicTacToe tc;
  @BeforeEach
  void initialize() {
    tc = new TicTacToe();
  }

  @Test
  void p1vertical() {
    tc.move(1);
    tc.move(2);
    tc.move(4);
    tc.move(5);
    tc.move(7);
    assertEquals(1, tc.winningPlayer());
  }
  @Test
  void p1horizontal() {
    tc.move(1);
    tc.move(4);
    tc.move(2);
    tc.move(5);
    tc.move(3);
    assertEquals(1, tc.winningPlayer());
  }
  @Test
  void p1diagonal() {
    tc.move(1);
    tc.move(2);
    tc.move(5);
    tc.move(3);
    tc.move(9);
    assertEquals(1, tc.winningPlayer());
  }
  @Test
  void p2vertical() {
    tc.move(3);
    tc.move(1);
    tc.move(2);
    tc.move(4);
    tc.move(5);
    tc.move(7);
    assertEquals(2, tc.winningPlayer());
  }
  @Test
  void p2horizontal() {
    tc.move(6);
    tc.move(1);
    tc.move(7);
    tc.move(2);
    tc.move(5);
    tc.move(3);
    assertEquals(2, tc.winningPlayer());
  }
  @Test
  void p2diagonal() {
    tc.move(4);
    tc.move(1);
    tc.move(2);
    tc.move(5);
    tc.move(3);
    tc.move(9);
    assertEquals(2, tc.winningPlayer());
  }
  @Test
  void draw() {
    tc.move(5);
    tc.move(1);
    tc.move(9);
    tc.move(3);
    tc.move(2);
    tc.move(8);
    tc.move(4);
    tc.move(6);
    tc.move(7);
    assertEquals(0, tc.winningPlayer());
  }
  @Test
  void outOfBoundsLower() {
    assertEquals(false, tc.move(-1));
  }
  @Test
  void outOfBoundsUpper() {
    assertEquals(false, tc.move(10));
  }
  @Test
  void alreadyTaken() {
    tc.move(1);
    assertEquals(false, tc.move(1));
  }
  @Test
  void reset() {
    tc.move(1);
    tc.move(2);
    tc.move(3);
    tc.move(4);
    tc.move(5);
    tc.move(6);
    tc.move(7);
    tc.reset();
    assertEquals(-1, tc.winningPlayer());
  }
}
