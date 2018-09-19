package com.codecool;

import com.codecool.model.daoloader.DAOLoader;
import com.codecool.user.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsDAO {

    public StudentsDAO() {
    }

    public List<Student> getListOfStudents(){
        DAOLoader daoloader = new DAOLoader("StudentsCSV.CSV");
        String[][] loader = daoloader.getFileContent();
        List<Student> studentsList = new ArrayList<Student>();
        for ( int i =0; i < loader.length; i++){
            for( int j =0; j < loader[i].length; j++){
                String id = loader[i][0];
                String userName = loader[i][1];
                String password = loader[i][2];
                String name = loader[i][3];
                String surname = loader[i][4];
                String phonNumber = loader[i][5];
                String emailAdders = loader[i][6];
                studentsList.add(new Student( id,userName, password ,name, surname, phonNumber, emailAdders ));
            }
        }
        return studentsList;
    }

    public String[][] exportListOfStudent(List<Student> studentList ){
        String[][] listOfStudents = new String[5][5];
        for ( int i =0; i < studentList.size(); i++ ){
            listOfStudents[i][0] = studentList.get(i).getId();
            listOfStudents[i][1] = studentList.get(i).getUserName();
            listOfStudents[i][2] = studentList.get(i).getPassword();
            listOfStudents[i][3] = studentList.get(i).getName();
            listOfStudents[i][4] = studentList.get(i).getSurname();
            listOfStudents[i][5] = studentList.get(i).getPhonNumber();
            listOfStudents[i][6] = studentList.get(i).getEmailAddres();
        }
        return listOfStudents;
    }

    public String toString( ){
        List<Student>studentsList = getListOfStudents();
        StringBuilder sBuilder = new StringBuilder();
        for( Student student  : studentsList ){
            sBuilder.append(student.toString() + "\n");
        }
        return sBuilder.toString();
    }



}
