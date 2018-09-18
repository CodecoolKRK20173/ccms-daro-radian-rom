package com.codecool.customexceptions;

public class UserNotLoggedException extends Exception{
    public UserNotLoggedException(String message){
        super(message);
    }
}
