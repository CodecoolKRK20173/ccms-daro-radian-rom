package com.codecool.DAO;

import com.codecool.user.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsDAO {

    private DataLoader daoloader = new DataLoader("StudentsCSV.CSV");

    public List<Student> getListOfStudents(){
//        DataLoader daoloader = new DataLoader("StudentsCSV.CSV");
        String[][] loader = daoloader.getFileContent();

        List<Student> studentsList = new ArrayList<Student>();

        for ( int i =0; i < loader.length; i++){
                String id = loader[i][0];
                String userName = loader[i][1];
                String password = loader[i][2];
                String name = loader[i][3];
                String surname = loader[i][4];
                String phonNumber = loader[i][5];
                String emailAdders = loader[i][6];
                studentsList.add(new Student( id,userName, password ,name, surname, phonNumber, emailAdders ));
        }
        return studentsList;
    }

    public void exportListOfStudent(List<Student> studentList ){
        int listSize = studentList.size();
        String[][] listOfStudents = new String[listSize][7];
        for ( int i =0; i < studentList.size(); i++ ){
            listOfStudents[i][0] = studentList.get(i).getId();
            listOfStudents[i][1] = studentList.get(i).getUserName();
            listOfStudents[i][2] = studentList.get(i).getPassword();
            listOfStudents[i][3] = studentList.get(i).getName();
            listOfStudents[i][4] = studentList.get(i).getSurname();
            listOfStudents[i][5] = studentList.get(i).getPhonNumber();
            listOfStudents[i][6] = studentList.get(i).getEmailAddres();
        }
        DataLoader daoloader = new DataLoader("StudentsCSV.CSV");
        daoloader.saveContentToFile(listOfStudents);
    }

    public String toString( ){
        List<Student>studentsList = getListOfStudents();
        StringBuilder sBuilder = new StringBuilder();
        for( Student student  : studentsList ){
            sBuilder.append( student.toString());
            sBuilder.append( "\n");
        }
        return sBuilder.toString();
    }

    public void addStudent( ){
        List<Student> studentsList = getListOfStudents();
        Student student = new Student( "id", "userName", "password",  "name",
                 "surname",  "phonNumber", "emailAdders" );
        studentsList.add( student );
        exportListOfStudent( studentsList );
    }

    public void removeStudent( int number ) {
        List<Student> studentsList = getListOfStudents();
        studentsList.remove( number);
        exportListOfStudent( studentsList );
    }

    public Student getStudentFromList( int number ){
        List<Student> studentList = getListOfStudents();
        Student student = studentList.get(number);
        return  student;
    }

}
