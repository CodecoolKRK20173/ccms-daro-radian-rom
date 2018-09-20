package com.codecool.view;

import com.codecool.user.Student;

import java.util.List;

public class EmployeeView extends ConsoleView implements StudentPrintable {
    @Override
    public void PrintStudent(List<Student> studentList) {
        int counter = 1;
        for (Student student: studentList) {
            System.out.println(counter + " "
                                + student.getName() + " "
                                + student.getSurname() + " "
                                + student.getPhoneNumber() + " "
                                + student.getEmailAddres());
            counter++;
        }
    }
}
