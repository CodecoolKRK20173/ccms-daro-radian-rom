package com.codecool;

import com.codecool.model.daoloader.DAOLoader;
import com.codecool.user.Mentor;
import com.codecool.user.Student;

import java.util.ArrayList;
import java.util.List;

public class MentorsDAO {

    public List<Student> getListOfMantors(){
        DAOLoader loader = new DAOLoader("MentorsCSV.CSV");
        String[][] loader = loader.getFileContent();
        List<Mentor> mentorsList = new ArrayList<Mentor>();
        for ( int i =0; i < loader.length; i++){
            for( int j =0; j < loader[i].length; j++){
                String id = loader[i][0];
                String userName = loader[i][1];
                String password = loader[i][2];
                String name = loader[i][3];
                String surname = loader[i][4];
                String phonNumber = loader[i][5];
                String emailAdders = loader[i][6];
                mentorsList.add(new Mentor( id,userName, password ,name, surname, phonNumber, emailAdders ));
            }
        }
        return mentorsList;
    }

    public String[][] exportListOfMentors(List<Mentor> mentorstList ){
        String[][] listOfMentors = new String[5][5];
        for ( int i =0; i < mentorstList.size(); i++ ){
            listOfMentors[i][0] = mentorstList.get(i).getId();
            listOfMentors[i][1] = mentorstList.get(i).getUserName();
            listOfMentors[i][2] = mentorstList.get(i).getPassword();
            listOfMentors[i][3] = mentorstList.get(i).getName();
            listOfMentors[i][4] = mentorstList.get(i).getSurname();
            listOfMentors[i][5] = mentorstList.get(i).getPhonNumber();
            listOfMentors[i][6] = mentorstList.get(i).getEmailAddres();
        }
        return listOfMentors;
    }

    public String[][] addMentor( Mentor mentor ){
        List<Mentor> mentorsList = getListOfMantors();
        return exportListOfMentors(mentorsList.add( mentor ));
    }

    public String[][] removeMentor( Mentor mentor ){
        List<Mentor> mentorsList = getListOfMantors();
        return exportListOfMentors(mentorsList.remove( mentor ));
    }

    public String toString( ){
        List<Mentor> mentorsList = getListOfMantors();
        StringBuilder sBuilder = new StringBuilder();
        for( Student student  : mentorsList ){
            sBuilder.append(student.toString() + "\n");
        }
        return sBuilder.toString();
    }





}
