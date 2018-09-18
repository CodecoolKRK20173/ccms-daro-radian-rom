package com.codecool;


public class Student {

    private String id;
    private String userName;
    private String name;
    private String surname;
    private String phonNumber:
    private String emailAddres:

    private List< Assignment > listOfTakenAssaigments;
    private List< Assignment > listOfSubmitetAssaigments;

    public Student(String id, String userName, String name, String surname, String phonNumber, String emailAddres) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.phonNumber = phonNumber;
        this.emailAddres = emailAddres;
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


    public List<Assignment> getListOfTakenAssaigments() {
        return listOfTakenAssaigments;
    }

    public List<Assignment> getListOfSubmitetAssaigments() {
        return listOfSubmitetAssaigments;
    }

    public void login(){
    }

    public void takeAssignment( Assignment assignment ){
        listOfTakenAssaigments.add(assignment);
    }

    public void submitAssignment( Assignment assignment ){

        listOfSubmitetAssaigments.add(assignment);
    }

    public void viewMyGrades(){

    }




}
