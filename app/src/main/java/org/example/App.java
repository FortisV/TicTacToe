package org.example;

public class App {
  public static void main(String[] args) {
    String error = "Invalid input";

    TicTacToe tc = new TicTacToe();

    ConsoleDecorations.printBanner("TicTacToe");
    boolean repeat = true;
    while (repeat) {
      while(tc.winningPlayer() == -1) {
        String divider = "Player " + tc.getCurrPlayer();
        String prompt = tc.stringBoard() + divider + " move: ";

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
      if (tc.winningPlayer() == 0) {
        ConsoleDecorations.printBanner("Draw");
      } else {
        ConsoleDecorations.printBanner("Player " + tc.winningPlayer() + " Won");
      }
      tc.printBoard();
      tc.reset();
      ConsoleDecorations.printDivider("Play Again?");
      String playAgainPrompt = "(1) Yes\n" +
              "(2) No\n" +
              "\n" +
              "Input: ";
      repeat = Input.getInteger(1, 2, playAgainPrompt, "Invalid Input") == 1;
    }
    ConsoleDecorations.printBanner("Exiting...");
  }
}
