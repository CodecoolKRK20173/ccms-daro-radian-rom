package com.codecool.user;

import java.time.LocalDate;
import com.codecool.DAO.AssignmentDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.DAO.SubmittedAssignmentDAO;
import com.codecool.model.assignment.Assignment;
import com.codecool.model.assignment.SubmittedAssignment;
import com.codecool.view.AssignmentView;
import com.codecool.view.StudentView;
import com.codecool.view.View;

import java.util.ArrayList;
import java.util.List;

public class StudentController extends UserController {

    private AssignmentView aview;
    private String studentID = "s3";
    private boolean isRunning = true;
    private SubmittedAssignmentDAO submittedAssignmentDAO;
    private StudentView view;
    private StudentsDAO studentsDAO;
    private AssignmentDAO assignmentDAO;

    public StudentController() {
        studentsDAO = new StudentsDAO();
        assignmentDAO = new AssignmentDAO();
        submittedAssignmentDAO = new SubmittedAssignmentDAO();
        view = new StudentView();
        aview = new AssignmentView();
    }

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
            aview.printListOfAssignmets(assignmentDAO.loadAssignments());
    }


    public void viewMyGrades(){
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
        SubmittedAssignmentDAO submittedAssignmentDAO = new SubmittedAssignmentDAO();
        submittedAssignmentDAO.addSubmittedAssignment( "a2",studentId);

    }
}
