package org.example;

public class App {
  TicTacToe tc;
  App() {
    tc = tc = new TicTacToe();
  }
  void greet() {
    ConsoleDecorations.printBanner("TicTacToe");
  }
  void exit() {
    ConsoleDecorations.printBanner("Exiting...");
  }
  boolean playAgain() {
    ConsoleDecorations.printDivider("Play Again?");
    String playAgainPrompt = "(1) Yes\n" +
            "(2) No\n" +
            "\n" +
            "Input: ";
    return Input.getInteger(1, 2, playAgainPrompt, "Invalid Input") == 1;
  }
  void startGame() {
    while(tc.winningPlayer() == -1) {
      String divider = "Player " + tc.getCurrPlayer();
      String prompt = tc.stringBoard() + divider + " move: ";
      String error = "Invalid input";

      ConsoleDecorations.printDivider(divider);

      int spot;
      boolean invalidMove = true;
      do {
        spot = Input.getInteger(1, 9, prompt, error);
        if (tc.move(spot)) {
          invalidMove = false;
        } else {
          System.out.println("Spot has already been taken\n");
        }
      } while(invalidMove);
    }

  }
  void displayWinner() {
    if (tc.winningPlayer() == 0) {
      ConsoleDecorations.printBanner("Draw");
    } else {
      ConsoleDecorations.printBanner("Player " + tc.winningPlayer() + " Won");
    }
    tc.printBoard();
  }
  void reset() {
    tc.reset();
  }
  void run() {
    greet();
    do {
      startGame();
      displayWinner();
      reset();
    } while(playAgain());
    exit();
  }
  public static void main(String[] args) {
    new App().run();
  }
}
