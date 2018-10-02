package com.codecool.user;

public class Staff extends User {
    public Staff(String id, String userName, String password, String name, String surname, String phonNumber, String emailAdders, String type) {
        super(id, userName, password, name, surname, phonNumber, emailAdders);
        this.type = type;
    }
}
