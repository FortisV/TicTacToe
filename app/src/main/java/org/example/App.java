package org.example;

public class App {
  private TicTacToe tc;
  private int computerPlayerNum;
  private ComputerPlayer computerPlayer;
  private int firstPlayer;
  private int p1w;
  private int p2w;
  private int tie;
  public App() {
    tc = tc = new TicTacToe();
    computerPlayerNum = 0;
    computerPlayer = null;
    firstPlayer = 1;
    p1w = 0;
    p2w = 0;
    tie = 0;
  }
  private void greet() {
    ConsoleDecorations.printBanner("TicTacToe");
  }
  private void gameType() {
    ConsoleDecorations.printDivider("Choose Game Type");
    String gameTypePrompt = "(1) Human vs Human\n" +
                            "(2) Human vs Computer\n" +
                            "(3) Computer vs Human\n" +
                            "\n" +
                            "Input: ";
    int gameType = Input.getInteger(1, 3, gameTypePrompt, "Invalid Input");
    switch(gameType) {
      case 1:
        computerPlayerNum = 0;
        break;
      case 2:
        computerPlayerNum = 2;
        computerPlayer = new ComputerPlayer(tc.getPlayer2Char(), tc.getPlayer1Char());
        break;
      case 3:
        computerPlayerNum = 1;
        computerPlayer = new ComputerPlayer(tc.getPlayer1Char(), tc.getPlayer2Char());
        break;
    }
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
  private void humanMove() {
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
  private void computerMove() {
    ConsoleDecorations.printDivider("Computer " + tc.getCurrPlayer());
    tc.printBoard();
    if(tc.getCurrMove() == 0) {
      tc.move(computerPlayer.firstMove());
    } else if(tc.getCurrMove() == 1) {
      tc.move(computerPlayer.secondMove(tc.getBoard()));
    } else {
      tc.move(computerPlayer.bestMove(tc.getBoard()));
    }
  }
  private void startGame() {
    while(tc.winningPlayer() == -1) {
      if(tc.getCurrPlayer() == computerPlayerNum) {
        computerMove();
      } else {
        humanMove();
      }
    }
    if(tc.winningPlayer() == 1) {
      firstPlayer = 2;
    } else if(tc.winningPlayer() == 2) {
      firstPlayer = 1;
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
    gameType();
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
