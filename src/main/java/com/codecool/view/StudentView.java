package com.codecool.view;

import com.codecool.assignment.Assignment;
import com.codecool.assignment.SubmittedAssignment;

import java.util.List;

public interface StudentView extends UserView {
    public void printAssignments(List<Assignment> assignmentList);
    public void printSubmittedAssignments(List<SubmittedAssignment> submittedAssignmentList);
}
