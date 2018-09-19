package com.codecool.user;


import com.codecool.DAO.AssignmentDAO;
import com.codecool.DAO.SubmittedAssignmentDAO;
import com.codecool.model.assignment.Assignment;
import com.codecool.view.View;

public class StudentController extends UserController {

    private boolean isRunning = true;
    View view = new View();
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
//                SubmitAssignment();
                break;
            case (3):
//                showListOfAssigments();
                break;
            case (0):
                isRunning = false;
                break;
        }
    }


    public void showListOfAssigments(){

    }

    public void viewMyGrades(){
        SubmittedAssignmentDAO submittedAssignmentDAO = new SubmittedAssignmentDAO();

    /*
    pobieram liste ocenionych zadan i wyciagam te które naleza do konkretnego studenta
     */
    }

    public void submitAssignment(){
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        Assignment assignment = assignmentDAO.getAssignmentById(String id);
        SubmittedAssignmentDAO submittedAssignmentDAO = new SubmittedAssignmentDAO();
        submittedAssignmentDAO.addSubmittedAssignment("assignmentId", "studentId");

    /*
    pobieram zadanie z listy zadan i przerzucam do listy submited assignmet z indexem konkretnego studenat
    */

    }




//    public Assignment takeAssiagnment(Assignment assignment ){
//        AssignmentDAO assigmentDAO = new AssignmentDAO();
//        List< Assignment > listofAssgiment = assigmentDAO.loadAssignments();
//        assignment = listofAssgiment.getAssignmentById();
//
//        return assignment;
//    }
//
//    public void filltakenAssignment( Assignment assignment ){
//        listOfTakenAssaingments.add(assignment);
//    }
//
//    public List< Assignment > submitAssignment( Assignment assignment ){
//        SubmitetAssignemtDAO  submitetAssignemtDAO = new SubmitetAssignemtDAO();
//        List< Assignment >  listofAssgiment = submitetAssignemtDAO.getListOfAssigment();
//        return listofAssgiment.add(assignment);
//    }
//


}
