package com.codecool;

import com.codecool.model.assignment.AssignmentDAO;
import com.codecool.view.*;

public class Main {
    public static void main(String[] args){
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        assignmentDAO.addAssignment("1234", "Hangman", "Zdzisław Kodziarz", "Hangman game");
    }
}
