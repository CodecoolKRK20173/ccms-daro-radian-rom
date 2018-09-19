package com.codecool.model.assignment;

import com.codecool.model.daoloader.DAOLoader;

import java.util.ArrayList;
import java.util.List;

public class AssignmentDAO {
    final private int ID_INDEX = 0;
    final private int NAME_INDEX = 1;
    final private int MENTOR_INDEX = 2;
    final private int DESCRIPTION_INDEX = 3;
    final private String sourceFileName = "assignments.csv";

    private DAOLoader daoLoader;

    public AssignmentDAO() {
        this.daoLoader = new DAOLoader(sourceFileName);
    }

    public void addAssignment(String id, String name, String mentor, String description) {
        List<Assignment> assignments = loadAssignments();
        assignments.add(new Assignment(id, name, mentor, description));
        saveAssignments(assignments);
    }

    public List<Assignment> loadAssignments() {
        List<Assignment> assignments = new ArrayList<Assignment>();
        String[][] fileContent = daoLoader.getFileContent();

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

        daoLoader.saveContentToFile(assignmentsDataToSave.toArray(new String[][]{}));

    }


}
