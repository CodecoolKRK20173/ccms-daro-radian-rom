package com.codecool.view;

import com.codecool.model.assignment.Assignment;
import com.codecool.model.assignment.SubmittedAssignment;

import java.util.List;

public interface StudentView extends UserView {
    void printAssignments(List<Assignment> assignmentList);
    void printSubmittedAssignments(List<SubmittedAssignment> submittedAssignmentList);
}
