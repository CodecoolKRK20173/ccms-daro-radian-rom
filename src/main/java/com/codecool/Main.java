package com.codecool;

import com.codecool.view.CCMSConsoleView;

public class Main {
    public static void main(String[] args){
        CCMSConsoleView ccmsView = new CCMSConsoleView();
        CCMS ccms = new CCMS(ccmsView);
        ccms.run();
    }
}
