package com.codecool;


import java.util.List;

public class StudentsDAO {

    private List<Student> studentsList;
    private Loader loader;
    private String[][] listOfStudents;


    public StudentsDAO(List<Student> studentsList) {
        this.studentsList = studentsList;
        louder = new Loader();
        listOfStudents = loader,getList();
    }

    public void fillListOfStudents(){
        for ( int i =0; i < listOfStudents.length(); i++){
            for( int j =0; j < listOfStudents[i].length(); j++){
                String id = listOfStudents[i][0];
                String userName = listOfStudents[i][1];
                String password = listOfStudents[i][2];
                String name = listOfStudents[i][3];
                String surname = listOfStudents[i][4];
                String phonNumber = listOfStudents[i][5];
                String emailAdders = listOfStudents[i][6];
                studentsList.add(new Student( id,userName, password ,name, surname, phonNumber, emailAdders ));
            }
        }
    }

    public void addStudent( Student student ){
        studentsList.add( student );
    }

    public void removeStudent( Student student ){
        studentsList.remove( student );
    }

    public void exportListOfStudent(){
        for ( int i =0; i < studentsList.size(); i++ ){
            listOfStudents[i][0] = studentsList.get(i).getId();
            listOfStudents[i][1] = studentsList.get(i).getUserName();
            listOfStudents[i][2] = studentsList.get(i).getPassword();
            listOfStudents[i][3] = studentsList.get(i).getName();
            listOfStudents[i][4] = studentsList.get(i).getSurname();
            listOfStudents[i][5] = studentsList.get(i).getPhonNumber();
            listOfStudents[i][6] = studentsList.get(i).getEmailAddres();
        }
    }


}
