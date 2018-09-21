package com.codecool.controller;


import com.codecool.DAO.AssignmentDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.DAO.SubmittedAssignmentDAO;
import com.codecool.login.Account;
import com.codecool.assignment.Assignment;
import com.codecool.assignment.SubmittedAssignment;
import com.codecool.user.UserController;
import com.codecool.view.StudentView;


import java.util.List;

public class StudentController extends UserController {

    private String studentID;
    private boolean isRunning = true;
    private SubmittedAssignmentDAO submittedAssignmentDAO;
    private StudentView view;
    private StudentsDAO studentsDAO;
    private AssignmentDAO assignmentDAO;

    public StudentController(Account account, StudentView view) {
        super(account);
        studentsDAO = new StudentsDAO();
        assignmentDAO = new AssignmentDAO();
        submittedAssignmentDAO = new SubmittedAssignmentDAO();
        this.view = view;
        studentID = account.getUserId();

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
                viewMyGrades();
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
        view.printAssignments(assignmentDAO.loadAssignments());
    }

    public void viewMyGrades(){
        String studentId = studentID;
        List<SubmittedAssignment> listSubmittedAssignment = submittedAssignmentDAO.loadSubmittedAssignments();
        for ( SubmittedAssignment  assignment : listSubmittedAssignment ){
            if(  assignment.getStudentId().equals(studentId)   ){
                System.out.println( assignment.getAssignmentId()+
                        assignment.getGrade()+
                        assignment.getMentorGraded());
            }
        }
    }

    public void submitAssignment(){
        List<Assignment> assignments = assignmentDAO.loadAssignments();
        Assignment assignment = assignments.get(view.askForNumber("Enter index of assignment."));
        String idAssignment  = assignment.getId();
        System.out.println(assignment);
        String studentId = studentID;
        submittedAssignmentDAO.addSubmittedAssignment( idAssignment,studentId);
    }
}
