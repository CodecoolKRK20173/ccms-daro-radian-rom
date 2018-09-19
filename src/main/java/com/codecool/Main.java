package com.codecool;


import com.codecool.DAO.AssignmentDAO;

public class Main {
    public static void main(String[] args){
        AssignmentDAO assignmentDAO = new AssignmentDAO();
        //assignmentDAO.addAssignment("dd", "klondike", "Jan Kowalski", "klondike game");
        //assignmentDAO.addAssignment("dd2", "klondike 2", "Jan Kowalski", "klondike game2");
        assignmentDAO.removeAssignment("dd2");

    }
}
