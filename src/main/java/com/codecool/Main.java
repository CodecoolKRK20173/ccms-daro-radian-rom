package com.codecool;

import com.codecool.view.*;

public class Main {
    public static void main(String[] args){
        View ccmsView = new View();
        CCMS ccms = new CCMS(ccmsView);
        ccms.run();
    }
}
