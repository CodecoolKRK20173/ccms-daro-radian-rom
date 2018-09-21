package com.codecool.view.consoleImplementations;

import com.codecool.user.Staff;
import com.codecool.user.Student;
import com.codecool.view.ManagerView;

import java.util.List;

public class ManagerConsoleView extends UserConsoleView implements ManagerView {
    @Override
    public void printStudents(List<Student> studentList) {
        StringBuilder sb;
        for (Student student : studentList){
            sb = new StringBuilder();
            sb.append(student.getId());    sb.append(" | ");
            sb.append(student.getName());  sb.append(" | ");
            sb.append(student.getSurname()); sb.append(" | ");
            sb.append(student.getType()); sb.append(" | ");
            sb.append(student.getEmailAddres()); sb.append(" | ");
            sb.append(student.getPhoneNumber());
            println(sb.toString());
        }
    }

    @Override
    public void printStaff(List<Staff> staffList) {
        StringBuilder sb;
        for (Staff staff : staffList){
            sb = new StringBuilder();
            sb.append(staff.getId());    sb.append(" | ");
            sb.append(staff.getName());  sb.append(" | ");
            sb.append(staff.getSurname()); sb.append(" | ");
            sb.append(staff.getType()); sb.append(" | ");
            sb.append(staff.getEmailAddres()); sb.append(" | ");
            sb.append(staff.getPhoneNumber());
            println(sb.toString());
        }

    }
}
