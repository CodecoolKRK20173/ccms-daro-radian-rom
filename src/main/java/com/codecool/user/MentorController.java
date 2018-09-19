package com.codecool.user;

import com.codecool.DAO.AssignmentDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.view.View;

import java.util.List;

public class MentorController extends UserController {

    private boolean isRunning = true;
    View view = new View();

    @Override
    public void run() {
        System.out.println("Metors");
        System.out.println("   1. Show student\n" +
                "   2. Add Student\n" +
                "   3. Remove Student\n" +
                "   4. Show info about Student\n"+
                "   5. Add assignmetn\n"+
                "   0. Exit\n");
        while(isRunning){
            handleMenu();
        }
    }

    public void handleMenu(){
        int userChoice = view.askForNumber("Enter number :");
        switch (userChoice) {
            case (1):
                showListOfStudenst();
                break;
            case (2):
                addStudent();
                break;
            case (3):
                int choice = view.askForNumber("Enter number :");
                removeStudent(choice);
                break;
            case (4):
//                int choice = view.askForNumber("Enter number :");
//                removeStudent(choice);
                break;
            case (5):
                AssignmentDAO assignmentDAO = new AssignmentDAO();
                assignmentDAO.addAssignment("id", "name", "mentor", "description");
                break;
            case (0):
                isRunning = false;
                break;
        }
    }

    public void removeStudent(int number){
        StudentsDAO studentsDAO = new StudentsDAO();
        studentsDAO.removeStudent(number);
    }

    public void addStudent(){
        StudentsDAO studentsDAO = new StudentsDAO();
        studentsDAO.addStudent( );
    }

    public void showListOfStudenst() {
        StudentsDAO studentsDAO = new StudentsDAO();
        System.out.println(studentsDAO.toString());
    }

    public void showInfoAboutStudent( int number ) {
        StudentsDAO studentsDAO = new StudentsDAO();
        Student student = studentsDAO.getStudentFromList( number );
        System.out.println(student.toString());
    }

//    public String addAssigment() {
//        return id;
//    }
//
//    public String gradeAssigment() {
//        return id;
//    }
//
//    public String checkAttendanceOfStudent() {
//        return id;
//    }

}
