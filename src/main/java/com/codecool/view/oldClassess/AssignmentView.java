package com.codecool.view.oldClassess;

import com.codecool.model.assignment.Assignment;
import com.codecool.view.consoleImplementations.ConsoleView;

import java.util.List;

public class AssignmentView extends ConsoleView {

    public void printListOfAssignmets( List<Assignment> assignments){
        int index = 1;
        for( Assignment assignmet: assignments){
            assignmet.getName();
            assignmet.getMentor();
            assignmet.getMentor();
            System.out.println( index+". "+ assignmet.getId()+" "+
                                            assignmet.getName()+" "+
                                            assignmet.getMentor()+" "+
                                            assignmet.getMentor());
            index++;
        }
    }


}
