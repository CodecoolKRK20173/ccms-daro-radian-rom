package com.codecool;

import com.codecool.DAO.MentorsDAO;
import com.codecool.DAO.StudentsDAO;
import com.codecool.view.*;

public class Main {
    public static void main(String[] args){
//        CCMSView ccmsView = new CCMSView();
//        CCMS ccms = new CCMS(ccmsView);
//        ccms.run();

        View view = new View();

        StudentsDAO std = new StudentsDAO();
        std.getListOfStudents();
        System.out.println(std.toString( ) );

        MentorsDAO mentdao = new MentorsDAO();
        System.out.println(mentdao.toString( ) );





    }
}
