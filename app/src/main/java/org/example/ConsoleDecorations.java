package org.example;

public class ConsoleDecorations {
    final static char VERT_CHAR = '|';
    final static char HORZ_CHAR = '-';
    final static char CORN_CHAR = '@';
    final static char BLANK_CHAR = ' ';

    final static char DIV_CHAR = '-';

    final static int CONSOLE_WIDTH = 80;

    static public String line(char c, int i) {
        String s = new String();
        for(int j = 0; j < i; ++j) {
            s += c;
        }
        return s;
    }
    static public String banner(String message) {
        String s = new String();
        int odd = message.length() % 2;
        int space = (CONSOLE_WIDTH - 2 - message.length()) / 2;
        s += CORN_CHAR + line(HORZ_CHAR, CONSOLE_WIDTH - 2) + CORN_CHAR + '\n';
        s += VERT_CHAR + line(BLANK_CHAR, space) + message + line(BLANK_CHAR, space + odd) + VERT_CHAR + '\n';
        s += CORN_CHAR + line(HORZ_CHAR, CONSOLE_WIDTH - 2) + CORN_CHAR;
        return s;
    }
    static public void printBanner(String message) {
        System.out.println(banner(message));
    }
    static public void printBanner() {
        printBanner("");
    }

    static public String divider(String message) {
        String s = new String();
        int odd = message.length() % 2;
        int space = (CONSOLE_WIDTH - message.length()) / 2;
        s += line(DIV_CHAR, space) + message + line(DIV_CHAR, space + odd);
        return s;
    }
    static public void printDivider(String message) {
        System.out.println(divider(message));
    }
    static public void printDivider() {
        printDivider("");
    }
}
