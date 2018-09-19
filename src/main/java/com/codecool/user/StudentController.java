package com.codecool.user;

import com.codecool.Assignment;
import com.codecool.model.assignment.AssignmentDAO;

import java.util.ArrayList;
import java.util.List;

public class StudentController extends UserController {

    @Override
    public void run() {

    }

    private List< Assignment > listOfTakenAssaingments = new ArrayList<>();
    private List< Assignment > listOfSubmitedAssaigments = new ArrayList<>();

    public String[][] addStudent( Student student ){
        List<Student> studentsList = getListOfStudents();
        return exportListOfStudent(studentsList.add( student ));
    }

    public String[][] removeStudent( String string ){
        List<Student> studentsList = getListOfStudents();
        studentsList.remove(string);
        String[][] listWithoutStudent = exportListOfStudent(studentsList);
        return listWithoutStudent;
    }

    public String getStudentFromList( String string){
        List<Student> studentList = getListOfStudents();
        Student student = studentList.get(string);
        return    student.toString();
    }

    public Assignment takeAssiagnment(Assignment assignment ){
        AssignmentDAO assigmentDAO = new AssignmentDAO();
        List< Assignment > listofAssgiment = assigmentDAO.loadAssignments();
        assignment = listofAssgiment.getAssignmentById();

        return assignment;
    }

    public void filltakenAssignment( Assignment assignment ){
        listOfTakenAssaingments.add(assignment);
    }

    public List< Assignment > submitAssignment( Assignment assignment ){
        SubmitetAssignemtDAO  submitetAssignemtDAO = new SubmitetAssignemtDAO();
        List< Assignment >  listofAssgiment = submitetAssignemtDAO.getListOfAssigment();
        return listofAssgiment.add(assignment);
    }

    public void viewMyGrades(){
    }

}
