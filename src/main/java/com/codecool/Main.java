package com.codecool;

import com.codecool.view.CCMSView;

public class Main {
    public static void main(String[] args){
        CCMSView ccmsView = new CCMSView();
        CCMS ccms = new CCMS(ccmsView);
        ccms.run();
    }
}
