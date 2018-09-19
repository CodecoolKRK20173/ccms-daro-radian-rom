package com.codecool.model.assignment;

import java.time.LocalDate;

public class SubmittedAssignment {
    private String assignmentId;
    private String studentId;
    private LocalDate submitted;
    private String mentorGraded;
    private int grade;
    private LocalDate graded;
    private boolean isGraded;

    public SubmittedAssignment(String assignmentId, String studentId) {
        this.assignmentId = assignmentId;
        this.studentId = studentId;
        submitted = LocalDate.now();
        mentorGraded = "";
        grade = 0;
        graded = null;
        isGraded = false;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public LocalDate getSubmitted() {
        return submitted;
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

    public String getGraded() {
        if (graded != null) {
            return graded.toString();
        }
        return "not graded yet";
    }

    public boolean isGraded() {
        return isGraded;
    }

    public void setMentorGraded(String mentorGraded) {
        this.mentorGraded = mentorGraded;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setGraded(LocalDate graded) {
        this.graded = graded;
    }

    public void setGraded(boolean graded) {
        isGraded = graded;
    }
}
