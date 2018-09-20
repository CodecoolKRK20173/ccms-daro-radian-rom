package com.codecool.view;

import com.codecool.model.assignment.Assignment;
import com.codecool.model.assignment.SubmittedAssignment;

import java.util.List;

public interface AssignmentPrintable {
    void printAssignment(List<Assignment> assignmentList);
    void printSubmittedAssignment(List<SubmittedAssignment> submittedAssignmentList);
}
