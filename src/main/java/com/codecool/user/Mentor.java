package com.codecool.user;

public class Mentor extends User {


    private String id;
    private String userName;
    private String password;
    private String name;
    private String surname;
    private String phonNumber;
    private String emailAddres;


    public Mentor(String id, String userName,
                  String password, String name,
                  String surname, String phonNumber,
                  String emailAddres) {

        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phonNumber = phonNumber;
        this.emailAddres = emailAddres;
    }


    public String showListOfStudenst() {
        return id;
    }

    public String addAssigment() {
        return id;
    }

    public String gradeAssigment() {
        return id;
    }


    public String checkAttendanceOfStudent() {
        return id;
    }


    public String addStudent() {
        return id;
    }


    public String removeStudent() {
        return id;
    }

    public String showStudent() {
        return id;
    }




    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public String getEmailAddres() {
        return emailAddres;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhonNumber(String phonNumber) {
        this.phonNumber = phonNumber;
    }

    public void setEmailAddres(String emailAddres) {
        this.emailAddres = emailAddres;
    }
}
