package com.codecool.view.consoleImplementations;

import com.codecool.view.View;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ConsoleView implements View {
    private final int EXIT_INPUT = 0;
    private final int MENU_BOTTOM_MARGIN = 2;
    private final String EXIT_OPTION_STRING = "Exit";
    private final String NOT_A_NUMBER_MESSAGE = "Please enter a number";
    private final float DEFAULT_DELAY_TIME_IN_SECONDS = 2.0f;
    private final String ASCII_ARTS_DIR = "resources/ascii-arts";
    private final Charset CHARSET = Charset.forName("ISO-8859-1");

    private Scanner scanner;

    public ConsoleView(){
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
        printBlankLines(MENU_BOTTOM_MARGIN);
    }
    protected void print(String message){
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
        scanner = new Scanner(System.in);

        print(askMessage);
        return scanner.nextLine().trim();
    }

    public int askForNumber(String askMessage){
        print(askMessage);
        int input = 0;
        boolean isInputANumber = false;

        do{
            // Not sure if good technique
            scanner = new Scanner(System.in);
            try{
                input = scanner.nextInt();
                isInputANumber = true;
            } catch (InputMismatchException e){
                printError(NOT_A_NUMBER_MESSAGE);
            }
        } while (!isInputANumber);

        return input;
    }

    public void waitAWhile(){
        try{
            Thread.sleep((int)(1000*DEFAULT_DELAY_TIME_IN_SECONDS));
            // TimeUnit.SECONDS.wait(DEFAULT_DELAY_TIME_IN_SECONDS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected List<String> getASCIIArtFromFile(String fileName){
        Path filePath = Paths.get(ASCII_ARTS_DIR, fileName);
        List<String> result = new LinkedList<>();

        try{
            result = Files.readAllLines(filePath, CHARSET);
        } catch (IOException e){
            e.printStackTrace();
        }

        return result;
    }
}
