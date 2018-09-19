package com.codecool;

import com.codecool.model.assignment.AssignmentDAO;
import com.codecool.view.*;

public class Main {
    public static void main(String[] args){
        CCMSView ccmsView = new CCMSView();
        CCMS ccms = new CCMS(ccmsView);
        ccms.run();
    }
}
