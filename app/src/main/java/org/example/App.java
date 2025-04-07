package org.example;



public class App {
  private TicTacToe tc;
  private int firstPlayer;
  private int p1w;
  private int p2w;
  private int tie;
  public App() {
    tc = tc = new TicTacToe();
    firstPlayer = 1;
    p1w = 0;
    p2w = 0;
    tie = 0;
  }
  private void greet() {
    ConsoleDecorations.printBanner("TicTacToe");
  }
  private void exit() {
    ConsoleDecorations.printBanner("Exiting...");
  }
  private boolean playAgain() {
    ConsoleDecorations.printDivider("Play Again?");
    String playAgainPrompt = "(1) Yes\n" +
                             "(2) No\n" +
                             "\n" +
                             "Input: ";
    return Input.getInteger(1, 2, playAgainPrompt, "Invalid Input") == 1;
  }
  private void startGame() {
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
    if(tc.winningPlayer() != 0) {
      firstPlayer = tc.winningPlayer();
    }
    switch(tc.winningPlayer()) {
      case 0:
        tie++;
        break;
      case 1:
        p1w++;
        break;
      case 2:
        p2w++;
        break;
    }
  }
  private void displayWinner() {
    if (tc.winningPlayer() == 0) {
      ConsoleDecorations.printBanner("Draw");
    } else {
      ConsoleDecorations.printBanner("Player " + tc.winningPlayer() + " Won");
    }
    tc.printBoard();
  }
  private void reset() {
    tc.reset(firstPlayer);
  }
  private void printGameLog() {
    ConsoleDecorations.printDivider("Statistics");
    System.out.println("Player 1 Wins: " + p1w);
    System.out.println("Player 2 Wins: " + p2w);
    System.out.println("Ties         : " + tie);
  }
  private void saveGameLog() {
    ConsoleDecorations.printDivider("Saving Statistics");
    System.out.println("Saving game statistics to game.txt");
    Writer writer = new Writer();
    writer.openFile("game.txt");
    writer.println("Player 1 Wins: " + p1w);
    writer.println("Player 2 Wins: " + p2w);
    writer.println("Ties         : " + tie);
    writer.close();
  }
  public void run() {
    greet();
    do {
      startGame();
      displayWinner();
      printGameLog();
      reset();
    } while(playAgain());
    saveGameLog();
    exit();
  }
  public static void main(String[] args) {
    new App().run();
  }
}

/*



- tc : TicTacToe

- greet (): void
- exit() : void
- playAgain() : boolean
- startGame() : void
- displayWinner() : void
- reset() : void
+ run() : void




*/
