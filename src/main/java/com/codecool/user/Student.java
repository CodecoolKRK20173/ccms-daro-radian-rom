package com.codecool.user;

public class Student extends User {

    public Student(String id, String userName, String password, String name, String surname, String phoneNumber, String emailAddres) {
        super(id, userName, password, name, surname, phoneNumber, emailAddres);
        type = "student";
    }
}