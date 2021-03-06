package com.codecool.controller;

import com.codecool.DAO.AssignmentDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.DAO.SubmittedAssignmentDAO;
import com.codecool.login.Account;
import com.codecool.assignment.SubmittedAssignment;
import com.codecool.login.AccountsDAO;
import com.codecool.user.Student;
import com.codecool.user.UserController;
import com.codecool.view.MentorView;

import java.time.LocalDate;
import java.util.List;

public class MentorController extends UserController {

    private boolean isRunning = true;
    private StudentsDAO studentsDAO;
    private AssignmentDAO assignmentDAO;
    private SubmittedAssignmentDAO submittedAssignmentDAO;
    private Account account;
    private MentorView view;
    private AccountsDAO accountsDAO;
    private final String[] OPTIONS = {"See list of students", "Add student", "Remove student", "Add assignment", "Show assignments",
                                      "Grade assignment"};

    public MentorController(Account account, MentorView view) {
        super(account);
        studentsDAO = new StudentsDAO();
        assignmentDAO = new AssignmentDAO();
        submittedAssignmentDAO = new SubmittedAssignmentDAO();
        accountsDAO = new AccountsDAO();
        this.view = view;
        this.account = account;
    }

    @Override
    public void run() {
        view.printWelcomeMessage("Mentor");
        while (isRunning) {
            view.printOptions(OPTIONS);
            handleMenu();
        }
    }

    public void handleMenu() {
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
                addNewAssignment();
                break;
            case (5):
                showListOfAssignments();
                break;
            case (6):
                gradeSubmittedAssignment();
                break;
            case (0):
                isRunning = false;
                break;
            default:
                view.printError("Unknown choice, try again...");
        }
    }

    public void showListOfStudenst() {

        view.printStudents(studentsDAO.getListOfStudents());
    }

    public void addStudent() {
        String id = view.askForText("Enter id : ");
        String userName = view.askForText("Enter userName : ");
        String password = view.askForText("Enter password : ");
        String name = view.askForText("Enter name : ");
        String surname = view.askForText("Enter surname : ");
        String phonNumber = view.askForText("Enter phonNumber : ");
        String emailAdders = view.askForText("Enter emailAdders : ");
        studentsDAO.addStudent(id, userName, password, name, surname, phonNumber, emailAdders);
        accountsDAO.makeAccount(id, userName, password, "student");
    }

    public void removeStudent() {
        List<Student> students = studentsDAO.getListOfStudents();
        showListOfStudenst();
        int choice = 0;
        boolean isChoiceCorrect = false;

        while (!isChoiceCorrect) {
            choice = view.askForNumber("Choose number of student to remove: ");
            isChoiceCorrect = choice > 0 && choice <= students.size();
            if (!isChoiceCorrect) {
                view.printError("Wrong choice, try again...");
            }
        }
        studentsDAO.removeStudent(choice);
    }

    public void showListOfAssignments() {
        view.printAssignments(assignmentDAO.loadAssignments());
    }

    public void addNewAssignment() {
        System.out.println(" Create new assignment : ");
        view.waitAWhile();
        String id = view.askForText("Enter id : ");
        String name = view.askForText("Enter title : ");
        String mentor = view.askForText("Enter mentor : ");
        String description = view.askForText("Enter description : ");
        assignmentDAO.addAssignment(id, name, mentor, description);
    }

    public void gradeSubmittedAssignment() {
        view.printSubmittedAssignments(submittedAssignmentDAO.loadSubmittedAssignments());

        String idOfAssignmentToGrade = view.askForText("Type id of submitted assignment to grade: ");
        SubmittedAssignment submittedAssignmentToGrade =  submittedAssignmentDAO.getSubmittedAssignmentById(idOfAssignmentToGrade);
        submittedAssignmentToGrade.setGrade(view.askForNumber("Type a grade: "));
        submittedAssignmentToGrade.setGraded(true);
        submittedAssignmentToGrade.setMentorGraded(account.getLogin());
        submittedAssignmentToGrade.setGradedDate(LocalDate.now().toString());

        List<SubmittedAssignment> submittedAssignments = submittedAssignmentDAO.loadSubmittedAssignments();
        submittedAssignments.add(submittedAssignmentToGrade);
        submittedAssignmentDAO.saveSubmittedAssignments(submittedAssignments);
    }

}
