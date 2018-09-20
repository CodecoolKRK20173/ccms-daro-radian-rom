package com.codecool.DAO;

import com.codecool.model.assignment.Assignment;

import java.util.ArrayList;
import java.util.List;

public class AssignmentDAO {
    final private int ID_INDEX = 0;
    final private int NAME_INDEX = 1;
    final private int MENTOR_INDEX = 2;
    final private int DESCRIPTION_INDEX = 3;
    final private String SOURCE_FILE_NAME = "assignments.csv";

    private DataLoader dataLoader;
    

    public AssignmentDAO() {
        this.dataLoader = new DataLoader(SOURCE_FILE_NAME);
    }

    public void addAssignment(String id, String name, String mentor, String description) {
        List<Assignment> assignments = loadAssignments();
        assignments.add(new Assignment(id, name, mentor, description));
        saveAssignments(assignments);
    }

    public  Assignment getAssignmentById(String id) {
        List<Assignment> assignments = loadAssignments();
        Assignment assignment = null;

        for (Assignment a: assignments) {
            if (a.getId().equals(id)) {
                assignment = a;
            }
        }
        return assignment;
    }

    public List<Assignment> loadAssignments() {
        List<Assignment> assignments = new ArrayList<Assignment>();
        String[][] fileContent = dataLoader.getFileContent();

        for (String[] row : fileContent) {
            Assignment assignmentToAdd = new Assignment(row[ID_INDEX],
                                                        row[NAME_INDEX],
                                                        row[MENTOR_INDEX],
                                                        row[DESCRIPTION_INDEX]);
            assignments.add(assignmentToAdd);
        }
        return assignments;
    }

    private void saveAssignments(List<Assignment> assignments) {
        ArrayList<String[]> assignmentsDataToSave = new ArrayList<String[]>();

        for (Assignment assignment: assignments) {
            String[] assignmentData = {assignment.getId(),
                                       assignment.getName(),
                                       assignment.getMentor(),
                                       assignment.getDescription()};
            assignmentsDataToSave.add(assignmentData);
        }

        dataLoader.saveContentToFile(assignmentsDataToSave.toArray(new String[][]{}));
    }

    public void removeAssignment(String assignmentId) {
        List<Assignment> assignments = loadAssignments();
        Assignment assignmentToRemove = null;

        for (Assignment assignment: assignments) {
            if (assignment.getId().equals(assignmentId)) assignmentToRemove = assignment;
        }

        assignments.remove(assignmentToRemove);
        saveAssignments(assignments);
    }




}
