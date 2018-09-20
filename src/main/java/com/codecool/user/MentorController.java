package com.codecool.user;

import com.codecool.DAO.AssignmentDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.view.ConsoleView;
import com.codecool.view.View;

public class MentorController extends UserController {

    private boolean isRunning = true;
    private View view =new ConsoleView();

    @Override
    public void run( ) {
        System.out.println("Mentors");
        System.out.println("   1. Show students\n" +
                "   2. Add Student.\n" +
                "   3. Remove Student.\n" +
                "   4. Show info about Student.\n"+
                "   5. Show list of assignments.\n"+
                "   6. Add assignmetn.\n"+
                "   0. Exit\n");
        while(isRunning){
            handleMenu();
        }
    }

    public void handleMenu(){
        int userChoice = view.askForNumber(" Enter number :");
        switch (userChoice) {
            case (1):
                showListOfStudenst();
                break;
            case (2):
                addStudent();
                break;
            case (3):
                removeStudent();
                break;
            case (4):
                showInfoAboutStudent();
                break;
            case (5):
                showListOfAssignment();
                break;
            case (6):
                addNewAssignment();
                break;
            case (0):
                isRunning = false;
                break;
        }
    }

    public void showListOfStudenst() {
        StudentsDAO studentsDAO = new StudentsDAO();
        System.out.println(studentsDAO.toString());
    }

    public void addStudent( ){
        view.waitAWhile();
        String id = view.askForText("Enter id : ");
        view.waitAWhile();
        String userName = view.askForText("Enter userName : ");
        view.waitAWhile();
        String password = view.askForText("Enter password : ");
        view.waitAWhile();
        String name = view.askForText("Enter name : ");
        view.waitAWhile();
        String surname = view.askForText("Enter surname : ");
        view.waitAWhile();
        String phonNumber = view.askForText("Enter phonNumber : ");
        view.waitAWhile();
        String emailAdders = view.askForText("Enter emailAdders : ");

        StudentsDAO studentsDAO = new StudentsDAO();
        studentsDAO.addStudent( id, userName, password, name, surname, phonNumber, emailAdders );
    }

    public void removeStudent(){
        StudentsDAO studentsDAO = new StudentsDAO();
        studentsDAO.removeStudent(view.askForNumber("Enter a number removed student:")-1);
    }

    public void showInfoAboutStudent( ) {
        StudentsDAO studentsDAO = new StudentsDAO();
        Student student = studentsDAO.getStudentFromList( view.askForNumber("Enter a student number to show :")-1);
        System.out.println(student.toString());
        System.out.println(" Students assignments :  ");

        /*
        wyciagam z listy "submited zadan" zadania z indexem danego studenta
        i wybrane zadanie oceniam.
         */
    }

    public void showListOfAssignment(){
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        System.out.println(assignmentDAO.loadAssignments());

    }

    public void addNewAssignment() {
        System.out.println( " Create new assignment : ");
        view.waitAWhile();
        String id = view.askForText("Enter id : ");
        view.waitAWhile();
        String name = view.askForText("Enter title : ");
        view.waitAWhile();
        String mentor = view.askForText("Enter mentor : ");
        view.waitAWhile();
        String description = view.askForText("Enter description : ");
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        assignmentDAO.addAssignment(id,name, mentor,description);
    }


//    public String gradeAssigment() {
//        return id;
//    }
//
//    public String checkAttendanceOfStudent() {
//        return id;
//    }

}

