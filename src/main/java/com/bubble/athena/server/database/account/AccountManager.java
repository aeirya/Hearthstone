package com.bubble.athena.server.database.account;

import java.util.List;

import com.bubble.athena.server.database.PersistenceManager;

import org.apache.log4j.Logger;

public class AccountManager {
    private AccountDao dao;

    public AccountManager(PersistenceManager persistence) {
        dao = new AccountDaoImpl(persistence);
    }

    public void create(String username, String password) {
        Account acc = new AccountCreator().setName(username).setPassword(password).build();
        dao.saveAccount(acc);
    }

    public void delete(String username) {
        Account acc = dao.getAccounts().stream().filter(a -> a.getName().equals(username)).findAny().orElse(null);
        if (acc != null) dao.deleteAccount(acc);
        else Logger.getLogger("database: ").warn("no such account was found");
    }

    public List<Account> getAccounts() {
        return dao.getAccounts();
    }
}