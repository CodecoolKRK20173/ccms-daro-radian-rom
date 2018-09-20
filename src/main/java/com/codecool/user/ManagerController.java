package com.codecool.user;

import com.codecool.DAO.StaffDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.login.Account;
import com.codecool.login.AccountsDAO;
import com.codecool.view.ManagerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ManagerController extends UserController {
    private final String WELCOME_MESSAGE = "";
    private final String[] OPTIONS = {"List employers", "List students", "Add employee",
                                      "Edit employee", "Remove employee"};
    private final String CHOOSE_OPTION_MESSAGE = "Choose action from list below:";
    private final String OPTION_REQUEST = "Option: ";
    private final String NO_OPTION_MESSAGE = "No such option! Choose another one";

    private AccountsDAO accountsDAO;
    private StaffDAO staffDAO;
    private StudentsDAO studentsDAO;
    private ManagerView view;
    private boolean isRunning;

    public ManagerController(Account account, ManagerView view){
        super(account);
        accountsDAO = new AccountsDAO();
        staffDAO = new StaffDAO();
        studentsDAO = new StudentsDAO();
        this.view = view;
    }

    @Override
    public void run() {
        isRunning = true;
        view.printWelcomeMessage("Jerzy");
        view.waitAWhile();

        while (isRunning){
            view.println(CHOOSE_OPTION_MESSAGE);
            view.printOptions(OPTIONS);
            handleMenu();
        }
    }

    private void handleMenu(){
        int option = view.askForNumber(OPTION_REQUEST);

        switch (option){
            case 0:
                isRunning = false;
                break;
            case 1:
                listEmployeers();
                break;
            case 2:
                listStudents();
                break;
            case 3:
                addEmployee();
                break;
            case 4:
                editEmployee();
                break;
            case 5:
                removeEmployee();
                break;
            default:
                view.printError(NO_OPTION_MESSAGE);
        }
    }

    private void listEmployeers(){
        view.printStaff(staffDAO.loadStaff());
    }

    private void listStudents(){
        view.printStudents(studentsDAO.getListOfStudents());
    }

    private void addEmployee(){
        String employeeId = view.askForText("Enter employee id: ");
        String login = view.askForText("Enter login: ");
        String password = view.askForText("Enter password: ");
        String name = view.askForText("Enter name: ");
        String surname = view.askForText("Enter surname: ");
        String email = view.askForText("Enter email: ");
        String phone = view.askForText("Enter phone number: ");
        String type = chooseTypeOfEmployee();
        staffDAO.addStaff(employeeId, login, password, name, surname, email, phone, type);
        accountsDAO.makeAccount(employeeId, login, password, type);
    }

    private void editEmployee(){
        view.printError("Option not available. Contact with administrator");
    }

    private void removeEmployee(){
        String employeeId = view.askForText("Enter employee id: ");
        staffDAO.removeStaff(employeeId);
    }

    private String chooseTypeOfEmployee() {
        List<String> types = new ArrayList<>(Arrays.asList("mentor", "employee"));
        String type = "";
        boolean isCorrect = false;

        while (!isCorrect) {
            type = view.askForText("Precise type of employee (employee or mentor): ");
            if (types.contains(type)) {
                isCorrect = true;
            } else {
                view.printError("Wrong choice, provide correct type...");
            }
        }
        return type;
    }
}
