package com.codecool.user;

import com.codecool.login.Account;

public abstract class UserController {
    protected Account account;

    protected UserController(Account account){
        this.account = account;
    }

    public abstract void run();
}
