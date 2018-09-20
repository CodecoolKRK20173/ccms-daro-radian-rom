package com.codecool.view;

public interface View {
    public abstract int getExitInput();
    public abstract void printOptions(String[] options);
    public abstract void println(String message);
    public abstract void printError(String message);
    public abstract void printBlankLines(int amount);
    public abstract String askForText(String askMessage);
    public abstract int askForNumber(String askMessage);
    public abstract void waitAWhile();
    public abstract void clearScreen();
}
