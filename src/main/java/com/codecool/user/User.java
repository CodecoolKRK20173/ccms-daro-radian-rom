package com.codecool.user;


public abstract class User {

    final int ID_TEXT_WIDTH = 2;
    final int USERNAME_TEXT_WIDTH = 15;
    final int PASSWORD_TEXT_WIDTH= 15;
    final int NAME_TEXT_WIDTH = 15;
    final int SURNAME_TEXT_WIDTH = 15;
    final int PHON_NUMBER_TEXT_WIDTH = 15;
    final int EMAIL_ADDRES_TEXT_WIDTH = 15;

    String id;
    String userName;
    String password;
    String name;
    String surname;
    String phoneNumber;
    String emailAddres;
    String type;

    public User(String id, String userName,
                   String password, String name,
                   String surname, String phonNumber,
                   String emailAdders) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phonNumber;
        this.emailAddres = emailAdders;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhonNumber(String phonNumber) {
        this.phoneNumber = phonNumber;
    }

    public void setEmailAddres(String emailAddres) {
        this.emailAddres = emailAddres;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddres() {
        return emailAddres;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public String toString(){
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(String.format("ID:%" + ID_TEXT_WIDTH + "s", id));
        sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", userName));
        sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", password));
        sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", name));
        sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", surname));
        sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", phoneNumber));
        sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", emailAddres));
        return sBuilder.toString();
    }
}