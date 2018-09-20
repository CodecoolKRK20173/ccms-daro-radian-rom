package com.codecool.view;

import com.codecool.model.assignment.Assignment;
import com.codecool.model.assignment.SubmittedAssignment;
import com.codecool.user.Student;

import java.util.List;

public interface MentorView extends UserView{
    public void printStudents(List<Student> studentList);
    public void printAssignments(List<Assignment> assignmentList);
    public void printSubmittedAssignments(List<SubmittedAssignment> submittedAssignmentList);
}
