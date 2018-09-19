package com.codecool;

import com.codecool.customexceptions.NoControllerForUserException;
import com.codecool.customexceptions.UserNotLoggedException;
import com.codecool.login.LoginController;
import com.codecool.login.UserSwitch;
import com.codecool.user.User;
import com.codecool.user.UserController;
import com.codecool.view.View;

public class CCMS {
    private LoginController loginController;
    private boolean isRunning;
    private final String[] MENU_OPTIONS = {"Login"};
    private final String ASK_FOR_INPUT = "Please enter a number of option from above list:";
    private View view;
    private User user;
    private UserController userController;

    public CCMS(View view){
        loginController = new LoginController(view);
        this.view = view;
        isRunning = true;
    }

    public void run(){
        while (isRunning){
            if (loginController.isUserLogger()){
                userController.run();
            } else {
                handleMenu();
            }
        }
    }

    private void handleMenu(){
        view.printOptions(MENU_OPTIONS);
        int option = -1;

        do{
            view.askForNumber(ASK_FOR_INPUT);
        } while (option < 0 || option > MENU_OPTIONS.length);

        switch (option){
            case 1:
                handleLogin();
                break;
            case 0:
                isRunning = false;
                break;
        }
    }

    private void handleLogin(){
        loginController.logIn();
        try{
            user = loginController.getLoggedUser();
        } catch (UserNotLoggedException e){
            view.printError(e.getMessage());
            return;
        }

        try{
            userController = new UserSwitch().getControllerForUser(user);
        } catch (NoControllerForUserException e){
            view.printError(e.getMessage());
        }
    }
}
