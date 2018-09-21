package com.codecool.view.consoleImplementations;

import com.codecool.user.Staff;
import com.codecool.user.Student;
import com.codecool.view.ManagerView;

import java.util.List;

public class ManagerConsoleView extends UserConsoleView implements ManagerView {
    private final int COLUMN_WIDTH = 14;
    @Override
    public void printStudents(List<Student> studentList) {
        StringBuilder sb;
        for (Student student : studentList){
            sb = new StringBuilder();
            sb.append(center(student.getId(), COLUMN_WIDTH));    sb.append(" | ");
            sb.append(center(student.getName(), COLUMN_WIDTH));  sb.append(" | ");
            sb.append(center(student.getSurname(), COLUMN_WIDTH)); sb.append(" | ");
            sb.append(center(student.getType(), COLUMN_WIDTH)); sb.append(" | ");
            sb.append(center(student.getEmailAddres(), COLUMN_WIDTH)); sb.append(" | ");
            sb.append(center(student.getPhoneNumber(), COLUMN_WIDTH));
            println(sb.toString());
        }
    }

    @Override
    public void printStaff(List<Staff> staffList) {
        StringBuilder sb;
        for (Staff staff : staffList){
            sb = new StringBuilder();
            sb.append(center(staff.getId(), COLUMN_WIDTH));    sb.append(" | ");
            sb.append(center(staff.getName(), COLUMN_WIDTH));  sb.append(" | ");
            sb.append(center(staff.getSurname(), COLUMN_WIDTH)); sb.append(" | ");
            sb.append(center(staff.getType(), COLUMN_WIDTH)); sb.append(" | ");
            sb.append(center(staff.getEmailAddres(), COLUMN_WIDTH)); sb.append(" | ");
            sb.append(center(staff.getPhoneNumber(), COLUMN_WIDTH));
            println(sb.toString());
        }

    }
}
