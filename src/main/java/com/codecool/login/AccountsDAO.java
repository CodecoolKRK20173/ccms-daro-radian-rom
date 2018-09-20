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
