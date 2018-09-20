package com.codecool.view.consoleImplementations;

import com.codecool.view.CCMSView;

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
