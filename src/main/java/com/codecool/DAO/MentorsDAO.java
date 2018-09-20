package com.codecool.DAO;

import com.codecool.user.Mentor;

import java.util.ArrayList;
import java.util.List;

public class MentorsDAO {

    private DataLoader daoloader;

    public MentorsDAO(DataLoader daoloader) {
        this.daoloader = daoloader;
    }

    public List<Mentor> getListOfMentors(){
        String[][] loader = daoloader.getFileContent();
        List<Mentor> mentorsList = new ArrayList<Mentor>();

        for ( int i =0; i < loader.length; i++){
            String id = loader[i][0];
            String userName = loader[i][1];
            String password = loader[i][2];
            String name = loader[i][3];
            String surname = loader[i][4];
            String phonNumber = loader[i][5];
            String emailAdders = loader[i][6];
            mentorsList.add(new Mentor( id,userName, password ,name, surname, phonNumber, emailAdders ));
            }
        return mentorsList;
    }

    public void exportListOfMentors(List<Mentor> mentorstList ){
        int listSize = mentorstList.size();
        String[][] listOfMentors = new String[listSize][7];
        for ( int i =0; i < mentorstList.size(); i++ ){
            listOfMentors[i][0] = mentorstList.get(i).getId();
            listOfMentors[i][1] = mentorstList.get(i).getUserName();
            listOfMentors[i][2] = mentorstList.get(i).getPassword();
            listOfMentors[i][3] = mentorstList.get(i).getName();
            listOfMentors[i][4] = mentorstList.get(i).getSurname();
            listOfMentors[i][5] = mentorstList.get(i).getPhonNumber();
            listOfMentors[i][6] = mentorstList.get(i).getEmailAddres();
        }
//        DataLoader daoloader = new DataLoader("MentorsCSV.CSV");
        daoloader.saveContentToFile(listOfMentors);
    }


    public String toString( ){
        List<Mentor> mentorsList = getListOfMentors();
        StringBuilder sBuilder = new StringBuilder();
        for( Mentor mentor  : mentorsList ){
            sBuilder.append(mentor.toString() + "\n");
        }
        return sBuilder.toString();
    }

    public void addMentor( ){
        List<Mentor> mentorsList = getListOfMentors();
        Mentor mentor = new Mentor( "id", "userName", "password",  "name",
                "surname",  "phonNumber", "emailAdders" );
        mentorsList.add( mentor );
        exportListOfMentors( mentorsList );
    }

    public void removeMentor( int number ) {
        List<Mentor> mentorsList = getListOfMentors();
        mentorsList.remove( number);
        exportListOfMentors( mentorsList );
    }

}
