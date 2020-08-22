package com.bubble.athena.server.database.account;

import com.bubble.util.secure.PasswordDigest;

public class AccountCreator {
    private Account account;
    
    public AccountCreator setId(int id) {
        account.setId(id);
        return this;
    }

    public AccountCreator() {
        begin();
    }

    public AccountCreator setName(String name) {
        account.setName(name);
        return this;
    }

    public AccountCreator setPassword(String password) {
        account.setPassword(password);
        account.setPassword(generatePassword(account));
        return this;
    }

    private String generatePassword(Account account) {
        return new PasswordDigest().generatePassword(account.getName(), account.getPassword());
    }

    private AccountCreator begin() {
        account = new Account();
        account.setCups(0);
        account.setGems(0);
        account.setMatchesLost(0);
        account.setMatchesLost(0);
        return this;
    }

    public Account build() {
        Account cache = account;
        account = null;
        return cache;
    }
}