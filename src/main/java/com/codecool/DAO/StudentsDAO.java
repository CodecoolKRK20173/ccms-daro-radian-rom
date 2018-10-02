package com.codecool.DAO;

import com.codecool.user.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentsDAO {

    private final int ID_INDEX = 0;
    private final int USER_NAME_INDEX = 1;
    private final int PASSWORD_INDEX = 2;
    private final int NAME_INDEX = 3;
    private final int SURNAME_INDEX = 4;
    private final int PHONENUMBER_INDEX = 5;
    private final int EMAIL_INDEX = 6;
//    private final int TYPE_INDEX = 7;

    DataLoader daoloader;
    IdBuilder idBuilder;

    public StudentsDAO() {
        daoloader = new DataLoader("StudentsCSV.CSV");
    }

    public List<Student> getListOfStudents(){
        String[][] loader = daoloader.getFileContent();
        List<Student> studentsList = new ArrayList<Student>();

        for ( int i =0; i < loader.length; i++){
                String id = loader[i][ID_INDEX];
                String userName = loader[i][USER_NAME_INDEX];
                String password = loader[i][PASSWORD_INDEX];
                String name = loader[i][NAME_INDEX];
                String surname = loader[i][SURNAME_INDEX];
                String phonNumber = loader[i][PHONENUMBER_INDEX];
                String emailAdders = loader[i][EMAIL_INDEX];
                studentsList.add(new Student( id,userName, password ,name, surname, phonNumber, emailAdders ));
        }
        return studentsList;
    }

    public void exportListOfStudent(List<Student> studentList ){
        int listSize = studentList.size();
        String[][] listOfStudents = new String[listSize][7];
        for ( int i =0; i < studentList.size(); i++ ){
            listOfStudents[i][ID_INDEX] = studentList.get(i).getId();
            listOfStudents[i][USER_NAME_INDEX] = studentList.get(i).getUserName();
            listOfStudents[i][PASSWORD_INDEX] = studentList.get(i).getPassword();
            listOfStudents[i][NAME_INDEX] = studentList.get(i).getName();
            listOfStudents[i][SURNAME_INDEX] = studentList.get(i).getSurname();
            listOfStudents[i][PHONENUMBER_INDEX] = studentList.get(i).getPhoneNumber();
            listOfStudents[i][EMAIL_INDEX] = studentList.get(i).getEmailAddres();
        }
        daoloader.saveContentToFile(listOfStudents);
    }

    public String toString( ){
        List<Student>studentsList = getListOfStudents();
        StringBuilder sBuilder = new StringBuilder();
        int index = 1;
        for( Student student  : studentsList ){
            sBuilder.append( index+". " );
            sBuilder.append( student.toString());
            sBuilder.append( "\n");
            index++;
        }
        return sBuilder.toString();
    }

    public void addStudent( String id, String userName, String password,String  name,
                            String  surname,  String phonNumber, String  emailAdders ){
        Student student = new Student( id, userName, password, name, surname, phonNumber, emailAdders );
        List<Student> studentsList = getListOfStudents();
        studentsList.add( student );
        exportListOfStudent( studentsList );
    }

    public void removeStudent( int number ) {
        List<Student> studentsList = getListOfStudents();
        studentsList.remove(number -1);
        exportListOfStudent( studentsList );
    }

    public Student getStudentFromList( int number ){
        List<Student> studentList = getListOfStudents();
        Student student = studentList.get(number);
        return  student;
    }



}
