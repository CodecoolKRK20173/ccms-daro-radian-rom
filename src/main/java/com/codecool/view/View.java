package com.codecool.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
    private final int EXIT_INPUT = 0;
    private final String EXIT_OPTION_STRING = "Exit";
    private final String NOT_A_NUMBER_MESSAGE = "Please enter a number";
    private final String WAIT_FOR_ACTION_MESSAGE = "Please press ENTER to continue...";

    private Scanner scanner;

    public View(){
        scanner = new Scanner(System.in);
    }

    public int getExitInput(){
        return EXIT_INPUT;
    }

    public void printOptions(String[] options){
        for (int i = 0; i < options.length; i++) {
            println(String.format("%d. %s", i+1, options[i]));
        }
        println(String.format("%d. %s", EXIT_INPUT, EXIT_OPTION_STRING));
    }
    private void print(String message){
        System.out.print(message);
    }

    public void println(String message){
        System.out.println(message);
    }

    public void printError(String errorMessage){
        System.out.println(String.format(" !  %s  ! ", errorMessage));
    }

    public void printBlankLines(int number){
        for (int i = 0; i < number; i++) {
            System.out.println();
        }
    }

    public String askForText(String askMessage){
        print(askMessage);
        return scanner.next();
    }

    public int askForNumber(String askMessage){
        println(askMessage);
        int input = 0;
        boolean isInputANumber = false;

        do{
            try{
                input = scanner.nextInt();
                isInputANumber = true;
            } catch (InputMismatchException e){
                printError(NOT_A_NUMBER_MESSAGE);
            }
        } while (!isInputANumber);

        return input;
    }

    public void waitForAction(){
        println(WAIT_FOR_ACTION_MESSAGE);
        scanner.next();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
