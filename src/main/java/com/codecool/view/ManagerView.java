package com.codecool.view;

import com.codecool.user.Staff;
import com.codecool.user.Student;

import java.util.List;

public interface ManagerView extends UserView {
    public void printStaff(List<Staff> staffList);
    public void printStudents(List<Student> studentList);
}
