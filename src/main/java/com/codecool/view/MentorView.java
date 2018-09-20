package com.codecool.view;

import com.codecool.model.assignment.Assignment;
import com.codecool.model.assignment.SubmittedAssignment;
import com.codecool.user.Student;

import java.util.List;

public interface MentorView extends UserView{
    void printStudents(List<Student> studentList);
    void printAssignments(List<Assignment> assignmentList);
    void printSubmittedAssignments(List<SubmittedAssignment> submittedAssignmentList);
}
