package com.codecool;

import com.codecool.DAO.MentorsDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.user.MentorController;
import com.codecool.user.StudentController;
import com.codecool.view.*;

public class Main {
    public static void main(String[] args){
//        CCMSView ccmsView = new CCMSView();
//        CCMS ccms = new CCMS(ccmsView);
//        ccms.run();

        MentorController mentorController = new MentorController();
        mentorController.run();

//        StudentController studentController = new StudentController();
//        studentController.run();
    }
}
