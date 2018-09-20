package com.codecool;

public class Main {
    public static void main(String[] args){
        CCMSConsoleView ccmsView = new CCMSConsoleView();
        CCMS ccms = new CCMS(ccmsView);
        ccms.run();
//        CCMSView ccmsView = new CCMSView();
//        CCMS ccms = new CCMS(ccmsView);
//        ccms.run();

        MentorController mentorController = new MentorController();
        mentorController.run();

//        StudentController studentController = new StudentController();
//        studentController.run();
    }
}
