package com.codecool.login;

import com.codecool.customexceptions.UserNotLoggedException;
import com.codecool.user.User;
import com.codecool.view.View;

public class LoginController {
    private final String NO_USER_ERROR_MESSAGE = "Tried to get non-existing user";
    private final String LOGIN_TITLE = "Please enter your login and password to proceed:";
    private final int TITLE_BOTTOM_MARGIN = 3;
    private final String ASK_FOR_LOGIN =    "Login:    ";
    private final String ASK_FOR_PASSWORD = "Password: ";

    private User loggedUser;
    private boolean isUserLogged;
    private View view;

    public LoginController(View view){
        isUserLogged = false;
        this.view = view;
    }

    public void logIn(){
        String login, password;
        boolean isLogging = true;

        view.println(LOGIN_TITLE);
        view.printBlankLines(TITLE_BOTTOM_MARGIN);

        while (isLogging){
            login = view.askForInput(ASK_FOR_LOGIN);
            password = view.askForInput(ASK_FOR_PASSWORD);

            // validate login and password
        }
        // create a new user and store in loggedUser
        isUserLogged = true;
    }

    public void logOut(){
        isUserLogged = false;
    }

    public boolean isUserLogger(){
        return isUserLogged;
    }

    public User getLoggedUser() throws UserNotLoggedException {
        if (isUserLogged){
            return loggedUser;
        }

        throw new UserNotLoggedException(NO_USER_ERROR_MESSAGE);
    }
}
