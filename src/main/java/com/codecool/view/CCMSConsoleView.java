package com.codecool.view;

import java.util.List;

public class CCMSConsoleView extends ConsoleView implements CCMSView {
    private final String APP_TITLE_FILE = "appTitle.txt";

    public void printAppTitle(){
        List<String> titleASCII = getASCIIArtFromFile(APP_TITLE_FILE);
        for (String line : titleASCII){
            println(line);
        }
    }
}
