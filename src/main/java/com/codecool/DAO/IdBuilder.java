package com.codecool.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IdBuilder{

        int ID = 2;
        DataLoader dataLoader;

        public IdBuilder(){
                this.dataLoader = new DataLoader( "accounts.csv" );
        }

    public List<String> makeListOfId(){
        String tempID;
        List<String> listOfID = new ArrayList<String>();
        String [][] loginInfo = dataLoader.getFileContent();
        for( int i =0; i < loginInfo.length;  i++ ){
            tempID = loginInfo[i][ID];
            listOfID.add(tempID);
        }
        return listOfID;
    }

    public String idGenerator( String type ) {
        String idPrefix = "";
        Random generator = new Random();
        StringBuilder sb = new StringBuilder();
        if ( type.equals("mentor")){
            idPrefix = "me";
        } else if  ( type.equals("employee")){
            idPrefix = "em";
        } else if ( type.equals("student")){
            idPrefix = "st";
        }
        sb.append(idPrefix).append(  generator.nextInt(( 900 )+1)+99  );
        return sb.toString();
    }


    public String getId (String type ){
        String generatedId  = idGenerator(type );
        makeListOfId();
        List<String >listOfId = makeListOfId();
        boolean flag = true;
        while(flag){
            for ( String id : listOfId){
                if ( generatedId == id ){
                    generatedId = idGenerator(type );
                }
            }
            flag = false;
        }
        return generatedId;
    }



}
