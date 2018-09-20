package com.codecool.user;

import com.codecool.DAO.AssignmentDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.DAO.SubmittedAssignmentDAO;
import com.codecool.model.assignment.Assignment;
import com.codecool.model.assignment.SubmittedAssignment;
import com.codecool.view.AssignmentView;
import com.codecool.view.StudentView;
import com.codecool.view.View;

import java.util.List;

public class MentorController extends UserController {

    private boolean isRunning = true;
    private StudentView view;
    private AssignmentView aview;
    StudentsDAO studentsDAO;
    AssignmentDAO assignmentDAO;
    SubmittedAssignmentDAO submittedAssignmentDAO;

    public MentorController() {
        studentsDAO = new StudentsDAO();
        assignmentDAO = new AssignmentDAO();
        submittedAssignmentDAO = new SubmittedAssignmentDAO();
        view = new StudentView();
        aview = new AssignmentView();
    }

    @Override
    public void run( ) {
        System.out.println("Mentors");
        System.out.println("   1. Show students\n" +
                "   2. Add Student.\n" +
                "   3. Remove Student.\n" +
                "   4. Show info about Student.\n"+
                "   5. Show list of assignments.\n"+
                "   6. Add new assignment to list.\n"+
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
                view.clearScreen();
                break;
            case (2):
                addStudent();
                view.clearScreen();
                break;
            case (3):
                removeStudent();
                view.clearScreen();
                break;
            case (4):
                showInfoAboutStudent();
                view.clearScreen();
                break;
            case (5):
                showListOfAssignment();
                view.clearScreen();
                break;
            case (6):
                addNewAssignment();
                view.clearScreen();
                break;
            case (0):
                isRunning = false;
                break;
        }
    }

    public void showListOfStudenst() {
        view.printListOfStudenst(studentsDAO.getListOfStudents());
    }

    public void addStudent( ){
        view.waitAWhile();
        String id = view.askForText("Enter id : ");
        view.waitAWhile();
        String userName = view.askForText("Enter userName : ");
        String password = view.askForText("Enter password : ");
        String name = view.askForText("Enter name : ");
        String surname = view.askForText("Enter surname : ");
        String phonNumber = view.askForText("Enter phonNumber : ");
        String emailAdders = view.askForText("Enter emailAdders : ");
        StudentsDAO studentsDAO = new StudentsDAO();
        studentsDAO.addStudent( id, userName, password, name, surname, phonNumber, emailAdders );
    }

    public void removeStudent(){
        studentsDAO.removeStudent(view.askForNumber("Enter a number removed student:")-1);
    }

    public void showInfoAboutStudent( ) {

        Student student = studentsDAO.getStudentFromList( view.askForNumber("Enter a student number to show :")-1);
        String studentID = student.getId();
        System.out.println(student.toString());
        System.out.println(" Students assignments :  ");
//        List<SubmittedAssignment>  listOfAssignmets = submittedAssignmentDAO.loadSubmittedAssignments();
//        for ( SubmittedAssignment sAssignmet : listOfAssignmets){
//            if (sAssignmet.getStudentId().equals(studentID )){
//                System.out.println( sAssignmet );
//            }
//        }
    }

    public void showListOfAssignment(){
            aview.printListOfAssignmets(assignmentDAO.loadAssignments());
    }

    public void addNewAssignment() {
        System.out.println( " Create new assignment : ");
        view.waitAWhile();
        String id = view.askForText("Enter id : ");
        String name = view.askForText("Enter title : ");
        String mentor = view.askForText("Enter mentor : ");
        String description = view.askForText("Enter description : ");
        assignmentDAO.addAssignment(id,name, mentor,description);
    }


//    public String gradeAssigment() {
//        return id;
//    }

//    public String checkAttendanceOfStudent() {
//        return id;

//    }
}
