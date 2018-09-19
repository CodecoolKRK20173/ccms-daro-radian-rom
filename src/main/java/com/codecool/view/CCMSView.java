package com.codecool.view;

import java.util.List;

public class CMSView extends View {
    private final String APP_TITLE_FILE = "appTitle.txt";

    public void printAppTitle(){
        List<String> titleASCII = getASCIIArtFromFile(APP_TITLE_FILE);
        for (String line : titleASCII){
            print(line);
        }
    }
}
