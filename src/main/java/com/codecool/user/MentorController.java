package com.codecool.user;

import com.codecool.DAO.AssignmentDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.DAO.SubmittedAssignmentDAO;
import com.codecool.login.Account;
import com.codecool.model.assignment.SubmittedAssignment;
import com.codecool.view.MentorView;

import java.util.List;

public class MentorController extends UserController {

    private boolean isRunning = true;
    StudentsDAO studentsDAO;
    AssignmentDAO assignmentDAO;
    SubmittedAssignmentDAO submittedAssignmentDAO;
    MentorView view;

    public MentorController(Account account, MentorView view) {
        super(account);
        studentsDAO = new StudentsDAO();
        assignmentDAO = new AssignmentDAO();
        submittedAssignmentDAO = new SubmittedAssignmentDAO();
        this.view = view;
    }

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
        view.printStudents(studentsDAO.getListOfStudents());
    }

    public void addStudent( ){
        String id = view.askForText("Enter id : ");
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
        List<SubmittedAssignment>  listOfAssignmets = submittedAssignmentDAO.loadSubmittedAssignments();
        int index = 1;
        for ( SubmittedAssignment sAssignmet : listOfAssignmets){
            if (sAssignmet.getStudentId().equals(studentID )){
                System.out.println( index +" "+ sAssignmet.getAssignmentId()
                        + " "+ sAssignmet.getIsGraded());
                index++;
            }
        }

        String idAssignment = view.askForText("Enter a ID of assignmet for grade : ");
        for ( SubmittedAssignment  assignment : listOfAssignmets){
            if (assignment.getAssignmentId().equals(idAssignment) ){
                assignment.setGrade(view.askForNumber("Enter a grade :"));
                assignment.setGraded(true);
            }
        }
    }

    public void showListOfAssignment(){
            view.printAssignments(assignmentDAO.loadAssignments());
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

//    }
}
