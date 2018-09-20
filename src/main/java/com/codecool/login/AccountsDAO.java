package com.codecool.login;

import com.codecool.DAO.DataLoader;
import com.codecool.customexceptions.FieldsNotInitializedException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AccountsDAO {
    private final String ACCOUNTS_FILE_NAME = "accounts.csv";
    private final int LOGIN_COLUMN = 0;
    private final int PASSWORD_COLUMN = 1;
    private final int USER_ID_COLUMN = 2;
    private final int ACCESS_LEVEL_COLUMN = 3;
    private final String MANAGER_ACCESS = "manager";
    private final String MENTOR_ACCESS = "mentor";
    private final String EMPLOYEE_ACCESS = "employee";
    private final String STUDENT_ACCESS = "student";

    private DataLoader dataLoader;
    private String[][] accounts;

    public AccountsDAO(){
        dataLoader = new DataLoader(ACCOUNTS_FILE_NAME);
    }

    public void makeAccount(String id, String login, String password, String accessLevel){
        loadAllAccounts();
        String[][] newAccounts = new String[accounts.length+1][4];
        for (int i=0; i<accounts.length; i++){
            newAccounts[i][LOGIN_COLUMN] = accounts[i][LOGIN_COLUMN];
            newAccounts[i][PASSWORD_COLUMN] = accounts[i][PASSWORD_COLUMN];
            newAccounts[i][USER_ID_COLUMN] = accounts[i][USER_ID_COLUMN];
            newAccounts[i][ACCESS_LEVEL_COLUMN] = accounts[i][ACCESS_LEVEL_COLUMN];
        }
        newAccounts[newAccounts.length-1][LOGIN_COLUMN] = login;
        newAccounts[newAccounts.length-1][PASSWORD_COLUMN] = password;
        newAccounts[newAccounts.length-1][USER_ID_COLUMN] = id;
        newAccounts[newAccounts.length-1][ACCESS_LEVEL_COLUMN] = accessLevel;

        dataLoader.saveContentToFile(newAccounts);
    }

    public Account getAccount(String login){
        loadAllAccounts();

        for (String[] account : accounts){
            if (account[LOGIN_COLUMN].equals(login)){
                AccessLevel accountAccessLevel = accessLevelValueOf(account[ACCESS_LEVEL_COLUMN]);
                try{
                    return new Account.AccountBuilder()
                            .withLogin(login)
                            .withPassword(account[PASSWORD_COLUMN])
                            .withID(account[USER_ID_COLUMN])
                            .withAccessLevel(accountAccessLevel)
                            .build();
                } catch (FieldsNotInitializedException e){
                    throw new NotImplementedException();
                }
            }
        }

        throw new IllegalArgumentException();
    }

    private AccessLevel accessLevelValueOf(String accessString){
        switch (accessString) {
            case MANAGER_ACCESS:
                return AccessLevel.MANAGER;
            case MENTOR_ACCESS:
                return AccessLevel.MENTOR;
            case EMPLOYEE_ACCESS:
                return AccessLevel.EMPLOYEE;
            case STUDENT_ACCESS:
                return AccessLevel.STUDENT;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void loadAllAccounts(){
        accounts = dataLoader.getFileContent();
    }
}
