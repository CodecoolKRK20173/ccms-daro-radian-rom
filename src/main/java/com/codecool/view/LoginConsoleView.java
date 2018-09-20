package com.codecool.view;

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
//        String pass = console.readPassword(askMessage).toString();
//        println(pass);
//        return pass;
//    }
}
