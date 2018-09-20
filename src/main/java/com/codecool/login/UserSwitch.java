package com.codecool.login;

import com.codecool.customexceptions.NoControllerForUserException;
import com.codecool.user.*;
import com.codecool.view.consoleImplementations.EmployeeConsoleView;
import com.codecool.view.consoleImplementations.ManagerConsoleView;
import com.codecool.view.consoleImplementations.MentorConsoleView;
import com.codecool.view.consoleImplementations.StudentConsoleView;

public class UserSwitch {
    private final String UNKNOWN_USER_ERROR =
            String.format("Given user is not recognized by %s class", getClass().getName());

    public UserController getControllerForAccount(Account account) throws NoControllerForUserException{
        AccessLevel accountAccessLevel = account.getAccessLevel();
        switch (accountAccessLevel) {
            case MANAGER:
                return new ManagerController(account, new ManagerConsoleView());
            case EMPLOYEE:
                return new EmployeeController(account, new EmployeeConsoleView());
            case MENTOR:
                return new MentorController(account, new MentorConsoleView());
            case STUDENT:
                return new StudentController(account, new StudentConsoleView());
            default:
                throw new NoControllerForUserException(UNKNOWN_USER_ERROR);
        }
    }
}
