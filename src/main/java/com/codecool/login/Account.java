package com.codecool.login;

import com.codecool.customexceptions.FieldsNotInitializedException;

public class Account {
    private String login;
    private String password;
    private String userId;
    private AccessLevel accessLevel;

    private Account (String login, String password, String userId, AccessLevel accessLevel){
        this.login = login;
        this.password = password;
        this.userId = userId;
        this.accessLevel = accessLevel;
    }

    public String getLogin(){
        return login;
    }

    public String getPassword(){
        return password;
    }

    public String getUserId(){
        return userId;
    }

    public AccessLevel getAccessLevel(){
        return accessLevel;
    }

    public static class AccountBuilder{
        private final String NULL_FIELDS_MESSAGE = "All account fields must be initialized!";

        private String login;
        private String password;
        private String userId;
        private AccessLevel accessLevel;

        public AccountBuilder withLogin(String login){
            this.login = login;
            return this;
        }

        public AccountBuilder withPassword(String password){
            this.password = password;
            return this;
        }

        public AccountBuilder withID(String id){
            userId = id;
            return this;
        }

        public AccountBuilder withAccessLevel(AccessLevel accessLevel){
            this.accessLevel = accessLevel;
            return this;
        }

        public Account build() throws FieldsNotInitializedException{
            if (login == null || password == null || userId == null || accessLevel == null){
                throw new FieldsNotInitializedException(NULL_FIELDS_MESSAGE);
            }

            return new Account(login, password, userId, accessLevel);
        }
    }
}
