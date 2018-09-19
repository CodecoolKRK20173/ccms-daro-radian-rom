package com.codecool.login;

import com.codecool.customexceptions.NoControllerForUserException;
import com.codecool.user.*;

public class UserSwitch {
    private final String UNKNOWN_USER_ERROR =
            String.format("Given user is not recognized by %s class.", getClass().getName());

    public UserController getControllerForUser(User user) throws NoControllerForUserException{
        if (user instanceof Manager){
            return new ManagerController();
        }
        if (user instanceof AdministrativeEmployee){
            return new AdministrativeEmployeeController();
        }
        if (user instanceof Mentor){
            return new MentorController();
        }
        if (user instanceof Student){
            return new StudentController();
        }

        throw new NoControllerForUserException(UNKNOWN_USER_ERROR);
    }
}
