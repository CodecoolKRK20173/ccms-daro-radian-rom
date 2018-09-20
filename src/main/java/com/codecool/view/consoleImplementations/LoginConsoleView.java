package com.codecool.view.consoleImplementations;

import com.codecool.view.LoginView;

public class LoginConsoleView extends ConsoleView implements LoginView {
    @Override
    public String askForPassword(String askMessage) {
        return askForText(askMessage);
    }
    //    @Override
//    public String askForPassword(String askMessage) {
//        Console console = System.console();
//        if (console == null){
//            throw new UnsupportedOperationException("No console found");
//        }
//
//        return console.readPassword(askMessage).toString();
//    }
}
