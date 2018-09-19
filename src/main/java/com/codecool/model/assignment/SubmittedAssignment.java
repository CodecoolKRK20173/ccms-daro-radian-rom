package com.codecool.model.assignment;

import java.time.LocalDate;

public class SubmittedAssignment {
    private String assignmentId;
    private String studentId;
    private String submittedDate;
    private String mentorGraded;
    private int grade;
    private String gradedDate;
    private boolean isGraded;

    public SubmittedAssignment(String assignmentId, String studentId, String submittedDate) {
        this.assignmentId = assignmentId;
        this.studentId = studentId;
        this.submittedDate = submittedDate;
        mentorGraded = "";
        grade = 0;
        gradedDate = null;
        isGraded = false;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getSubmittedDate() {
        return submittedDate;
    }

    public String getMentorGraded() {
        if (mentorGraded.equals("")) {
            return "not graded yet";
        }
        return mentorGraded;
    }

    public int getGrade() {
        return grade;
    }

    public String getGradedDate() {
        if (gradedDate != null) {
            return gradedDate.toString();
        }
        return "not graded yet";
    }

    public boolean getIsGraded() {
        return isGraded;
    }

    public void setMentorGraded(String mentorGraded) {
        this.mentorGraded = mentorGraded;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setGradedDate(LocalDate gradedDate) {
        this.gradedDate = gradedDate.toString();
    }

    public void setGraded(boolean graded) {
        isGraded = graded;
    }
}
