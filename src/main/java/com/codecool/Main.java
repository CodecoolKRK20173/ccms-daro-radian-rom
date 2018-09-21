package com.codecool;

import com.codecool.user.MentorController;
import com.codecool.user.StudentController;
import com.codecool.view.CCMSView;
import com.codecool.view.consoleImplementations.CCMSConsoleView;

public class Main {
    public static void main(String[] args){

        CCMSView ccmsView = new CCMSConsoleView();
        CCMS ccms = new CCMS(ccmsView);
        ccms.run();
    }
}
