package com.codecool.user;

import com.codecool.Assignment;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    public static class Student {

        private final int ID_TEXT_WIDTH = 4;
        private final int USERNAME_TEXT_WIDTH = 15;
        private final int PASSWORD_TEXT_WIDTH= 15;
        private final int NAME_TEXT_WIDTH = 15;
        private final int SURNAME_TEXT_WIDTH = 15;
        private final int PHON_NUMBER_TEXT_WIDTH = 15;
        private final int EMAIL_ADDRES_TEXT_WIDTH = 15;

        private String id;
        private String userName;
        private String password;
        private String name;
        private String surname;
        private String phonNumber;
        private String emailAddres;

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


        public Assignment takeAssiagnment( Assignment assignment ){
            AssigmentDAO  assigmentDAO = new AssigmentDAO();
            List< Assignment >  listofAssgiment = assignment.getListOfAssigment();
            assignment = listofAssgiment.getAssaingment();

            return assignment;
        }

        public void filltakenAssignment( Assignment assignment ){
            listOfTakenAssaingments.add(assignment);
        }


        public List< Assignment > submitAssignment( Assignment assignment ){
            SubmitetAssignemtDAO  submitetAssignemtDAO = new SubmitetAssignemtDAO();
            List< Assignment >  listofAssgiment = submitetAssignemtDAO.getListOfAssigment();
            return listofAssgiment.add(assignment);
        }


        public void viewMyGrades(){
        }

        public String toString(){
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append(String.format("ID:%" + ID_TEXT_WIDTH + "s", id));
            sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", userName));

            return sBuilder.toString();

        }




    }
}
