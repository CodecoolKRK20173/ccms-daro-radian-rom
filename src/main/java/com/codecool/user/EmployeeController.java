package com.codecool.user;

import com.codecool.DAO.StudentsDAO;
import com.codecool.login.Account;
import com.codecool.view.EmployeeView;

public class EmployeeController extends UserController {
    private final String[] OPTIONS = {"See a list of students"};
    private StudentsDAO studentsDAO;
    private EmployeeView view;
    private Account account;

    public EmployeeController(Account account, EmployeeView view) {
        super(account);
        studentsDAO = new StudentsDAO();
        this.view = view;
    }


    @Override
    public void run() {
        boolean isRunning = true;

        while (isRunning) {
            view.clearScreen();
            view.printOptions(OPTIONS);
            int choice = view.askForNumber("Option");

            switch (choice) {
                case 1:
                    view.printStudents(studentsDAO.getListOfStudents());
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    view.printError("Unknown choice!");
            }
            view.askForText("PRESS ENTER TO CONTINUE...");
        }
    }
}
