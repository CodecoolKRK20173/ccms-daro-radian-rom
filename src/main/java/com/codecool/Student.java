package com.codecool;


import java.util.ArrayList;

public class Student {

    private String id;
    private String userName;
    private String password;
    private String name;
    private String surname;
    private String phonNumber:
    private String emailAddres:

    private List< Assignment > listOfTakenAssaingments = new ArrayList<>();
    private List< Assignment > listOfSubmitedAssaigments = new ArrayList<>();

    public Student(String id, String userName,
                   String password, String name,
                   String surname, String phonNumber,
                   String emailAdders) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phonNumber = phonNumber;
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
        this.phonNumber = phonNumber;
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

    public String getPhonNumber() {
        return phonNumber;
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


    public List<Assignment> getListOfTakenAssaigments() {
        return listOfTakenAssaingments;
    }

    public List<Assignment> getListOfSubmitetAssaigments() {
        return listOfSubmitedAssaigments;
    }

    public void login(){
    }

    public void takeAssignment( Assignment assignment ){
        listOfTakenAssaingments.add(assignment);
    }

    public void submitAssignment( Assignment assignment ){
        listOfTakenAssaingments.get( ? );
        listOfSubmitedAssaigments.add(assignment);
    }

    public void viewMyGrades(){

    }




}
