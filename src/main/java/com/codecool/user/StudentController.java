package com.codecool.user;

import com.codecool.DAO.AssignmentDAO;
import com.codecool.DAO.SubmittedAssignmentDAO;
import com.codecool.model.assignment.Assignment;
import com.codecool.model.assignment.SubmittedAssignment;
import com.codecool.view.ConsoleView;
import com.codecool.view.View;

import java.util.List;

public class StudentController extends UserController {

    String studentID = "s3";
    private boolean isRunning = true;

    View view = new ConsoleView();
    @Override
    public void run() {
        System.out.println("Student");
        System.out.println("   1. View my grades\n" +
                "   2. Submit assignment.\n" +
                "   3. Show list of assignments.\n" +
                "   0. Exit\n");

        while(isRunning){
            handleMenu();
        }
    }

    public void handleMenu(){
        int userChoice = view.askForNumber("Enter number :");
        switch (userChoice) {
            case (1):
//                viewMyGrades();
                break;
            case (2):
                submitAssignment();
                break;
            case (3):
                showListOfAssigments();
                break;
            case (0):
                isRunning = false;
                break;
        }
    }


    public void showListOfAssigments(){
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        for ( Assignment assagnment : assignmentDAO.loadAssignments()){
            System.out.println(assagnment);
        }
    }

    public void viewMyGrades(){
        SubmittedAssignmentDAO submittedAssignmentDAO = new SubmittedAssignmentDAO();
        List<SubmittedAssignment> listSubmittedAssignment = submittedAssignmentDAO.loadSubmittedAssignments();

    /*
    pobieram liste ocenionych zadan i wyciagam te które naleza do konkretnego studenta
     */
    }

    /*
    pobieram zadanie z listy zadan i przerzucam do listy submited assignmet z indexem konkretnego studenat
    */
    public void submitAssignment(){
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        Assignment assignment = assignmentDAO.getAssignmentById(view.askForText("Enter id of assignment : "));
        view.waitAWhile();
        System.out.println(assignment);
        // jak pobrac id aktualnego studenta który aktualnie operuje ???????????????????????????
        String studentId = studentID;
//        SubmittedAssignmentDAO submittedAssignmentDAO = new SubmittedAssignmentDAO();
//        submittedAssignmentDAO.addSubmittedAssignment( "a2",studentId);

    }
}
