package com.codecool.user;

import com.codecool.Assignment;
import com.codecool.view.View;

import java.util.ArrayList;
import java.util.List;

public class StudentController extends UserController {

    private boolean isRunning = true;
    View view = new View();
    @Override
    public void run() {
        System.out.println("Student");
        System.out.println("   1. View my grades\n" +
                "   2. Submit assigment.\n" +
                "   3. Show list of assigments.\n" +
                "   0. Exit\n");

        while(isRunning){
            handleMenu();
        }
    }

    public void handleMenu(){
        int userChoice = view.askForNumber("Enter number :");
        switch (userChoice) {
            case (1):
//                showListOfStudenst();
                break;
            case (2):
//                addStudent();
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




        }
//    private List< Assignment > listOfTakenAssaingments = new ArrayList<>();
//    private List< Assignment > listOfSubmitedAssaigments = new ArrayList<>();
//
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
//    public void viewMyGrades(){
//    }

}
