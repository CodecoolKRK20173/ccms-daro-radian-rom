package com.codecool.user;

import com.codecool.DAO.StudentsDAO;
import com.codecool.login.Account;
import com.codecool.view.EmployeeView;
import com.codecool.view.View;

public class EmployeeController extends UserController {
    private final String[] OPTIONS = {"See a list of students"};
    private StudentsDAO studentsDAO;
    private View view;
    private Account account;

    public EmployeeController(Account account) {
        studentsDAO = new StudentsDAO();
        view = new EmployeeView();
        this.account = account;
    }



    @Override
    public void run() {

    }
}
