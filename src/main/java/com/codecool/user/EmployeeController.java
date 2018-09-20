package com.codecool.user;

import com.codecool.DAO.StudentsDAO;
import com.codecool.login.Account;
import com.codecool.view.EmployeeView;

public class EmployeeController extends UserController {
    private final String[] OPTIONS = {"See a list of students"};
    private StudentsDAO studentsDAO;
    private EmployeeView employeeView;
    private Account account;

    public EmployeeController(Account account, EmployeeView employeeView) {
        studentsDAO = new StudentsDAO();
        this.employeeView = employeeView;
        this.account = account;
    }


    @Override
    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            employeeView.clearScreen();
            employeeView.printOptions(OPTIONS);
            int choice = employeeView.askForNumber("Option");

            switch (choice) {
                case 1:
                    employeeView.printStudent(studentsDAO.getListOfStudents());
                case 0:
                    isRunning = false;
                default:
                    employeeView.printError("Unknown choice!");
            }
            employeeView.askForText("PRESS ENTER TO CONTINUE...");
        }
    }
}
