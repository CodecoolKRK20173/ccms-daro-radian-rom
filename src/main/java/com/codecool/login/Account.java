package com.codecool.login;

public class Account {
    private String login;
    private String password;
    private String userId;
    private Access access;

    public Account (String login, String password, String userId, Access access){
        this.login = login;
        this.password = password;
        this.userId = userId;
        this.access = access;
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

    public Access getAccess(){
        return access;
    }
}
