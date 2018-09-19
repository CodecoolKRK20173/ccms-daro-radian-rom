package com.codecool;

import com.codecool.customexceptions.NoControllerForUserException;
import com.codecool.customexceptions.UserNotLoggedException;
import com.codecool.login.Account;
import com.codecool.login.LoginController;
import com.codecool.login.UserSwitch;
import com.codecool.user.UserController;
import com.codecool.view.CCMSView;

public class CCMS {
    private LoginController loginController;
    private boolean isRunning;
    private final String[] MENU_OPTIONS = {"Login"};
    private final String BEFORE_INPUT_MESSAGE = "Please enter a number of option from above list:";
    private final String OPTION_NOT_RECOGNIZED_MESSAGE = "Sorry, this option seems to be corrupted." +
                                                         " Please, contact the administrator";
    private final String ASK_FOR_OPTION = "Option: ";

    private CCMSView view;
    private Account account;
    private UserController userController;

    public CCMS(CCMSView view){
        loginController = new LoginController(view);
        this.view = view;
        isRunning = true;
    }

    public void run(){
        view.clearScreen();
        view.printAppTitle();
        view.waitAWhile();
        while (isRunning){
            if (loginController.isUserLogged()){
                userController.run();
            } else {
                handleMenu();
            }
        }
    }

    private void handleMenu(){
        view.clearScreen();
        view.printAppTitle();
        view.printOptions(MENU_OPTIONS);
        int option = -1;

        do{
            view.println(BEFORE_INPUT_MESSAGE);
            option = view.askForNumber(ASK_FOR_OPTION);
        } while (option < 0 || option > MENU_OPTIONS.length);

        if (option == view.getExitInput()){
            isRunning = false;
        } else {
            switch (option){
                case 1:
                    handleLogin();
                    break;
                default:
                    view.printError(OPTION_NOT_RECOGNIZED_MESSAGE);
                    view.waitAWhile();
                    break;
            }
        }
    }

    private void handleLogin(){
        loginController.logIn();
        if (loginController.isUserLogged()){
            initializeUserController();
        }
    }

    private void initializeUserController(){
        try{
            account = loginController.getLoggedUser();
        } catch (UserNotLoggedException e){
            view.printError(e.getMessage());
            return;
        }

        try{
            userController = new UserSwitch().getControllerForUser(account);
        } catch (NoControllerForUserException e){
            view.printError(e.getMessage());
        }
    }
}
