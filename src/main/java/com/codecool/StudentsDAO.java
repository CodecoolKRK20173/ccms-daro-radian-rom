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



    public void createdListOfStudents(){
        for ( int i =0; i < listOfStudents.length(); i++){
            for( int j =0; j < listOfStudents[i].length(); j++){
                String id = listOfStudents[i][0];

            }
        }
    }

    public void addStudent(Student student){
        studentsList.add( student() );
    }

    public void removeStudent(Student student){
        studentsList.remove(student);
    }




}
