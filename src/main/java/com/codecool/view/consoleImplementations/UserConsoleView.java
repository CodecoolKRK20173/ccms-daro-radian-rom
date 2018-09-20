package com.codecool.view.consoleImplementations;

import com.codecool.view.UserView;

public abstract class UserConsoleView extends ConsoleView implements UserView {
    protected final String WELCOME_MESSAGE = "Welcome %s in Codecool Management System!";

    @Override
    public void printWelcomeMessage(String userName) {
        clearScreen();
        println(String.format(WELCOME_MESSAGE, userName));
    }
}
