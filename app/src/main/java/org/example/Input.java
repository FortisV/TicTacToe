package org.example;

import java.util.Scanner;

public class Input {
    static private final Scanner SCANNER = new Scanner(System.in);
    static double getDoubleMax(double max, String prompt, String error) {
        return getDouble(Double.NEGATIVE_INFINITY, max, prompt, error);
    }
    static double getDoubleMin(double min, String prompt, String error) {
        return getDouble(min, Double.POSITIVE_INFINITY, prompt, error);
    }
    static double getDouble(String prompt, String error) {
        return getDouble(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, prompt, error);
    }
    static double getDouble(double min, double max, String prompt, String error) {
        double inputNumber = -1;
        boolean repeat = true;
        while(repeat) {
            try {
                System.out.print(prompt);
                inputNumber = Double.parseDouble(SCANNER.nextLine());
                if (inputNumber > max || inputNumber < min) {
                    System.out.println(error + '\n');
                } else {
                    repeat = false;
                }
            } catch(Exception e) {
                System.out.println(error + '\n');
            }
        }

        return inputNumber;
    }
    static int getIntegerMax(int max, String prompt, String error) {
        return getInteger(Integer.MIN_VALUE, max, prompt, error);
    }
    static int getIntegerMin(int min, String prompt, String error) {
        return getInteger(min, Integer.MAX_VALUE, prompt, error);
    }
    static int getInteger(String prompt, String error) {
        return getInteger(Integer.MIN_VALUE, Integer.MAX_VALUE, prompt, error);
    }
    static int getInteger(int min, int max, String prompt, String error) {
        int inputNumber = -1;
        boolean repeat = true;
        while(repeat) {
            try {
                System.out.print(prompt);
                inputNumber = Integer.parseInt(SCANNER.nextLine());
                if (inputNumber > max || inputNumber < min) {
                    System.out.println(error + '\n');
                } else {
                    repeat = false;
                }
            } catch(Exception e) {
                System.out.println(error + '\n');
            }
        }

        return inputNumber;
    }
    static String getString(String prompt, String error) {
        return getString(true, prompt, error);
    }
    static String getString(boolean canBlank, String prompt, String error) {
        String input = "";
        boolean repeat = true;
        while(repeat) {
            try {
                System.out.print(prompt);
                input = SCANNER.nextLine();
                if(!canBlank && input.isBlank()) {
                    System.out.println(error + '\n');
                } else {
                    repeat = false;
                }
            } catch (Exception e) {
                System.out.println(error + '\n');
            }
        }

        return input;
    }
}
