package com.codecool.user;


public class Student extends User {

        private final int ID_TEXT_WIDTH = 4;
        private final int USERNAME_TEXT_WIDTH = 5;
        private final int PASSWORD_TEXT_WIDTH= 5;
        private final int NAME_TEXT_WIDTH = 5;
        private final int SURNAME_TEXT_WIDTH = 5;
        private final int PHON_NUMBER_TEXT_WIDTH = 5;
        private final int EMAIL_ADDRES_TEXT_WIDTH = 5;

        private String id;
        private String userName;
        private String password;
        private String name;
        private String surname;
        private String phonNumber;
        private String emailAddres;


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


        public String toString(){
            StringBuilder sBuilder = new StringBuilder();
            sBuilder.append(String.format("ID:%" + ID_TEXT_WIDTH + "s", id));
            sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", userName));
            sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", password));
            sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", name));
            sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", surname));
            sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", phonNumber));
            sBuilder.append(String.format(" | %-" + USERNAME_TEXT_WIDTH + "s", emailAddres));

            return sBuilder.toString();

        }
}

