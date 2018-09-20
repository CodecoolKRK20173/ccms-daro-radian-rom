package com.codecool.user;


public class Student extends User {

        public Student(String id, String userName,
                       String password, String name,
                       String surname, String phonNumber,
                       String emailAdders) {
            super(id, userName, password, name, surname, phonNumber, emailAdders);
            type = "student";
        }
}

