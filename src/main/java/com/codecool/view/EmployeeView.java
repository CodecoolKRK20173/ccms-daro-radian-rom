package com.codecool.view;

import com.codecool.user.Student;

import java.util.List;

public interface EmployeeView extends UserView {
    public void PrintStudent(List<Student> studentList);
}
