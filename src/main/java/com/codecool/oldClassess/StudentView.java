package com.codecool.oldClassess;

import com.codecool.user.Student;
import com.codecool.view.consoleImplementations.ConsoleView;

import java.util.List;

public class StudentView extends ConsoleView {

    public void printListOfStudenst(List<Student> studentsList){
        int index = 1;
        for( Student student : studentsList){
            System.out.println( index+". "+student.toString());
            index++;
        }
    }

}
