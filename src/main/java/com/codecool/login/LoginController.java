package com.codecool.login;

import com.codecool.customexceptions.UserNotLoggedException;
import com.codecool.view.LoginView;

public class LoginController {
    private final String NO_USER_ERROR_MESSAGE = "Tried to get non-existing user";
    private final String LOGIN_TITLE = "Please enter your login and password to proceed:";
    private final String QUIT_INPUT = "Q";
    private final String QUIT_OPTION_INFO = String.format("(Enter '%s' as login to quit)", QUIT_INPUT);
    private final int TITLE_BOTTOM_MARGIN = 3;
    private final String ASK_FOR_LOGIN =    "Login:    ";
    private final String ASK_FOR_PASSWORD = "Password: ";
    private final int MINIMUM_LOGIN_LENGHT = 4;
    private final String LOGIN_TOO_SHORT_MESSAGE =
            String.format("Login must be at least %d characters long", MINIMUM_LOGIN_LENGHT);
    private final String LOGIN_COINTAINS_WHITE_SPACE_MESSAGE = "Login cannot contain white spaces";
    private final String AUTHENTICATION_FAILED_MESSAGE = "Sorry, given login and password doesn't match";

    private Account loggedAccount;
    private boolean isUserLogged;
    private LoginView view;

    public LoginController(LoginView view){
        isUserLogged = false;
        this.view = view;
    }

    public void logIn(){
        String login, password;

        boolean isLoginCorrect = false;
        boolean isPasswordCorrect = false;

        do{
            printLoginScreen();
            login = view.askForText(ASK_FOR_LOGIN);

            if (login.toUpperCase().equals(QUIT_INPUT)) {
                return;
            }
        } while (!validateLogin(login));

        password = view.askForPassword(ASK_FOR_PASSWORD);
        Account chosenAccount;
        try{
            chosenAccount = getAccount(login);
        } catch (IllegalArgumentException e){
            view.println(AUTHENTICATION_FAILED_MESSAGE);
            view.waitAWhile();
            return;
        }

        if (validatePassword(chosenAccount, password)){
            loggedAccount = chosenAccount;
            isUserLogged = true;
        } else {
            view.println(AUTHENTICATION_FAILED_MESSAGE);
            view.waitAWhile();
        }
    }

    private Account getAccount(String login) throws IllegalArgumentException{
        return new AccountsDAO().getAccount(login);
    }

    private void printLoginScreen(){
        view.clearScreen();
        view.println(LOGIN_TITLE);
        view.println(QUIT_OPTION_INFO);
        view.printBlankLines(TITLE_BOTTOM_MARGIN);
    }

    private boolean validateLogin(String login){
        login = login.trim();
        if (login.length() < MINIMUM_LOGIN_LENGHT){
            view.printError(LOGIN_TOO_SHORT_MESSAGE);
            view.waitAWhile();
            return false;
        }

        for (int i = 0; i < login.length(); i++) {
            if (Character.isWhitespace(login.charAt(i))){
                view.printError(LOGIN_COINTAINS_WHITE_SPACE_MESSAGE);
                view.waitAWhile();
                return false;
            }
        }

        return true;
    }

    private boolean validatePassword(Account account, String password){
        return account.getPassword().equals(password);
    }

    public void logOut(){
        isUserLogged = false;
    }

    public boolean isUserLogged(){
        return isUserLogged;
    }

    public Account getLoggedUser() throws UserNotLoggedException {
        if (isUserLogged){
            return loggedAccount;
        }

        throw new UserNotLoggedException(NO_USER_ERROR_MESSAGE);
    }
}
