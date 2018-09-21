package com.codecool.view.consoleImplementations;

import com.codecool.user.User;
import com.codecool.view.UserView;

import java.util.List;

public abstract class UserConsoleView extends ConsoleView implements UserView {
    private final int COLUMN_WIDTH = 14;
    protected final String WELCOME_MESSAGE = "Welcome %s in Codecool Management System!";

    @Override
    public void printWelcomeMessage(String userName) {
        clearScreen();
        println(String.format(WELCOME_MESSAGE, userName));
    }

    protected void printUsers(List<User> users){
        StringBuilder sb;
        for (User user : users){
            sb = new StringBuilder();
            sb.append(center(user.getId(), COLUMN_WIDTH));    sb.append(" | ");
            sb.append(center(user.getName(), COLUMN_WIDTH));  sb.append(" | ");
            sb.append(center(user.getSurname(), COLUMN_WIDTH)); sb.append(" | ");
            sb.append(center(user.getType(), COLUMN_WIDTH)); sb.append(" | ");
            sb.append(center(user.getEmailAddres(), COLUMN_WIDTH)); sb.append(" | ");
            sb.append(center(user.getPhoneNumber(), COLUMN_WIDTH));
            println(sb.toString());
        }
    }

    private String center (String s, int width){
        int padSize = width - s.length();
        int padStart = s.length() + padSize / 2;

        s = String.format("%" + padStart + "s", s);
        s = String.format("%-" + width  + "s", s);
        return s;
    }
}
