package com.codecool.DAO;

import com.codecool.assignment.SubmittedAssignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SubmittedAssignmentDAO {
    final private String sourceFileName = "submitted_assignments.csv";
    final private int ID_INDEX = 0;
    final private int STUDENT_ID_INDEX = 1;
    final private int SUBMITTED_DATE_INDEX = 2;
    final private int MENTOR_INDEX = 3;
    final private int GRADE_INDEX = 4;
    final private int GRADED_DATE_INDEX = 5;
    final private int IS_GRADED_INDEX = 6;

    private DataLoader dataLoader;

    public SubmittedAssignmentDAO() {
        dataLoader = new DataLoader(sourceFileName);
    }

    public List<SubmittedAssignment> loadSubmittedAssignments() {
        String[][] fileContent = dataLoader.getFileContent();
        List<SubmittedAssignment> submittedAssignments = new ArrayList<>();

        for (String[] row: fileContent) {
            SubmittedAssignment submittedAssignment = new SubmittedAssignment(row[ID_INDEX],
                                                                              row[STUDENT_ID_INDEX],
                                                                              row[SUBMITTED_DATE_INDEX]);
            submittedAssignment.setMentorGraded(row[MENTOR_INDEX]);
            submittedAssignment.setGrade(Integer.valueOf(row[GRADE_INDEX]));
            submittedAssignment.setGradedDate(row[GRADED_DATE_INDEX]);
            submittedAssignment.setGraded(Boolean.valueOf(row[IS_GRADED_INDEX]));
            submittedAssignments.add(submittedAssignment);
        }
        return submittedAssignments;
    }

    public SubmittedAssignment getSubmittedAssignmentById(String id) {
        List<SubmittedAssignment> submittedAssignments = loadSubmittedAssignments();
        SubmittedAssignment wantedSubmittedAssignment = null;

        for (SubmittedAssignment submittedAssignment: submittedAssignments) {
            if (submittedAssignment.getAssignmentId().equals(id)) {
                wantedSubmittedAssignment = submittedAssignment;
            }
        }
        submittedAssignments.remove(wantedSubmittedAssignment);
        saveSubmittedAssignments(submittedAssignments);

        return wantedSubmittedAssignment;
    }

    public void saveSubmittedAssignments(List<SubmittedAssignment> submittedAssignments) {
        List<String[]> submittedAssignmentsDataToSave = new ArrayList<>();

        for (SubmittedAssignment submittedAssignment: submittedAssignments) {
            String[] submittedAssignmentData = {submittedAssignment.getAssignmentId(),
                                                submittedAssignment.getStudentId(),
                                                submittedAssignment.getSubmittedDate().toString(),
                                                submittedAssignment.getMentorGraded(),
                                                String.valueOf(submittedAssignment.getGrade()),
                                                submittedAssignment.getGradedDate(),
                                                String.valueOf(submittedAssignment.getIsGraded())};
            submittedAssignmentsDataToSave.add(submittedAssignmentData);
        }
        dataLoader.saveContentToFile(submittedAssignmentsDataToSave.toArray(new String[][]{}));
    }

    public void addSubmittedAssignment(String assignmentId, String studentId) {
        List<SubmittedAssignment> submittedAssignments = loadSubmittedAssignments();
        submittedAssignments.add(new SubmittedAssignment(assignmentId, studentId, LocalDate.now().toString()));
        saveSubmittedAssignments(submittedAssignments);
    }

    public void removeSubmittedAssignment(String assignmentId) {
        List<SubmittedAssignment> submittedAssignments = loadSubmittedAssignments();
        SubmittedAssignment submittedAssignmentToRemove = null;

        for (SubmittedAssignment submittedAssignment: submittedAssignments) {
            if (submittedAssignment.getAssignmentId().equals(assignmentId))
                submittedAssignmentToRemove = submittedAssignment;
        }

        submittedAssignments.remove(submittedAssignmentToRemove);
        saveSubmittedAssignments(submittedAssignments);
    }
}
