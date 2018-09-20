package com.codecool;

<<<<<<< Temporary merge branch 1

import com.codecool.DAO.AssignmentDAO;

public class Main {
    public static void main(String[] args){
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        //assignmentDAO.addAssignment("dd", "klondike", "Jan Kowalski", "klondike game");
        //assignmentDAO.addAssignment("dd2", "klondike 2", "Jan Kowalski", "klondike game2");
        assignmentDAO.removeAssignment("dd2");

=======
import com.codecool.DAO.MentorsDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.user.MentorController;
import com.codecool.user.StudentController;
import com.codecool.view.*;

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
