package com.codecool.customexceptions;

public class FieldsNotInitializedException extends Exception {
    public FieldsNotInitializedException(String message){
        super(message);
    }
}
