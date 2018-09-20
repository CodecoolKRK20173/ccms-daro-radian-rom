package com.codecool.user;

import com.codecool.DAO.StaffDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.login.Account;
import com.codecool.view.ManagerView;

public class ManagerController extends UserController {
    private final String WELCOME_MESSAGE = "";
    private final String[] OPTIONS = {"List employers", "List students", "Add employee",
                                      "Edit employee", "Remove employee"};

    private StaffDAO staffDAO;
    private StudentsDAO studentsDAO;
    private ManagerView view;

    public ManagerController(Account account, ManagerView view){
        super(account);
        staffDAO = new StaffDAO();
        studentsDAO = new StudentsDAO();
        this.view = view;
    }

    @Override
    public void run() {

    }

    private void handleMenu(){
        view.println("");
    }
}
