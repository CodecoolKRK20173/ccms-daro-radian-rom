package com.codecool.login;

import com.codecool.customexceptions.NoControllerForUserException;
import com.codecool.user.*;

public class UserSwitch {
    private final String UNKNOWN_USER_ERROR =
            String.format("Given user is not recognized by %s class", getClass().getName());

    public UserController getControllerForAccount(Account account) throws NoControllerForUserException{
        AccessLevel accountAccessLevel = account.getAccessLevel();
        switch (accountAccessLevel) {
            case MANAGER:
                return new ManagerController();
            case EMPLOYEE:
                return new AdministrativeEmployeeController();
            case MENTOR:
                return new MentorController();
            case STUDENT:
                return new StudentController();
            default:
                throw new NoControllerForUserException(UNKNOWN_USER_ERROR);
        }
    }
}
