package com.codecool.view.consoleImplementations;

import com.codecool.assignment.Assignment;
import com.codecool.assignment.SubmittedAssignment;
import com.codecool.user.Student;
import com.codecool.view.MentorView;

import java.util.List;

public class MentorConsoleView extends UserConsoleView implements MentorView {
    @Override
    public void printStudents(List<Student> studentList) {
        clearScreen();
        int index = 1;
        for( Student student : studentList){
            System.out.println( index+". "+student.toString());
            index++;
        }
    }

    @Override
    public void printAssignments(List<Assignment> assignmentList) {
        clearScreen();
        int index = 1;
        for( Assignment assignmet: assignmentList){
            assignmet.getName();
            assignmet.getMentor();
            System.out.println( index+". "+ assignmet.getId()+" "+
                    assignmet.getName()+" "+
                    assignmet.getMentor()+" "+
                    assignmet.getMentor());
            index++;
        }
    }

    @Override
    public void printSubmittedAssignments(List<SubmittedAssignment> submittedAssignmentList) {
         clearScreen();
//       List<SubmittedAssignment> listSubmittedAssignment = submittedAssignmentDAO.loadSubmittedAssignments();
        int index = 1;
        for ( SubmittedAssignment  assignment : submittedAssignmentList ){
//          System.out.println( index+". "+ assignment.toString());
            String assignmentId =  assignment.getAssignmentId();
            String studentId =  assignment.getStudentId();
            String submittedDate =  assignment.getSubmittedDate();
            Boolean isGraded =  assignment.getIsGraded();
            String mentorGraded =  assignment.getMentorGraded();
            System.out.println( index+". "+ assignmentId+" "+studentId+
                            submittedDate+" "+isGraded+" "+mentorGraded );
            index++;
        }
    }

}
