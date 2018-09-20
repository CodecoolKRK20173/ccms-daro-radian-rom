package com.codecool.user;

import com.codecool.DAO.StaffDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.view.View;

public class ManagerController extends UserController {
    private final String WELCOME_MESSAGE = "";
    private final String[] OPTIONS = {"List employers", "List students", "Add employee",
                                      "Edit employee", "Remove employee"};

    private View view;
    private StaffDAO staffDAO;
    private StudentsDAO studentsDAO;

    public ManagerController(View view){
        this.view = view;
        staffDAO = new StaffDAO();
        studentsDAO = new StudentsDAO();
    }

    @Override
    public void run() {

    }

    private void handleMenu(){
        view.println("");
    }
}
