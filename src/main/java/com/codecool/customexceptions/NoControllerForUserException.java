package com.codecool.customexceptions;

public class NoControllerForUserException extends Exception {
    public NoControllerForUserException(String message){
        super(message);
    }
}
