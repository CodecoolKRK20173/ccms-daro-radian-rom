package com.codecool.DAO;

import java.util.Random;

public class IdBuilder{

        public String idGenerator( String type ) {
                String idPrefix = "";
                Random generator = new Random();
                StringBuilder sb = new StringBuilder();
                if ( type == "mentor"){
                        idPrefix = "me";
                }
                if ( type == "employee"){
                        idPrefix = "em";
                }
                if ( type == "student"){
                        idPrefix = "st";
                }
                sb.append(idPrefix).append(generator.nextInt(999) );
                return sb.toString();
        }


}
