package com.codecool.view;

import com.codecool.DAO.StudentsDAO;
import com.codecool.user.Student;

import java.util.List;

public class StudentView extends View {

    public void printListOfStudenst(List<Student> studentsList){
        int index = 1;
        for( Student student : studentsList){
            System.out.println( index+". "+student.toString());
            index++;
        }
    }

}
