package com.codecool;

import com.codecool.user.MentorController;
import com.codecool.user.StudentController;

public class Main {
    public static void main(String[] args){

//        CCMSView ccmsView = new CCMSView();
//        CCMS ccms = new CCMS(ccmsView);
//        ccms.run();

//        MentorController mentorController = new MentorController();
//        mentorController.run();

        StudentController studentController = new StudentController();
        studentController.run();
    }
}
