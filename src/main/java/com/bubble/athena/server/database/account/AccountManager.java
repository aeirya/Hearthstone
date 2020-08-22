package com.bubble.athena.server.database.account;

import java.util.List;

import com.bubble.athena.server.database.PersistenceManager;
import com.bubble.util.secure.PasswordDigest;

import org.apache.log4j.Logger;

public class AccountManager implements IAccountManager {
    private AccountDao dao;
    private Logger logger;

    public AccountManager(PersistenceManager persistence) {
        logger = Logger.getLogger("database");
        dao = new AccountDaoImpl(persistence);
    }

    public void create(String username, String password) {
        if (exists(username)) {
            logger.warn("user " + username + " already exists");
        } else {
            Account acc = new AccountCreator().setName(username).setPassword(password).build();
            dao.saveAccount(acc);
            logger.info("created new user: " + username);
        }
    }

    private boolean exists(String username) {
        return getAccounts().stream().anyMatch(a -> a.getName().equals(username));
    }

    public void delete(String username) {
        Account acc = dao.getAccounts().stream().filter(a -> a.getName().equals(username)).findAny().orElse(null);
        if (acc != null) {
            dao.deleteAccount(acc);
            logger.info(username + " was deleted");
        }
        else logger.warn("no such account was found");
    }

    public List<Account> getAccounts() {
        return dao.getAccounts();
    }

    public Account getAccount(String username) {
        return getAccounts().stream().filter(a -> a.getName().equals(username)).findAny().orElse(null);
    }

    public boolean authenticate(String username, String password) {
        final String hash = new PasswordDigest().generatePassword(username, password);
        return getAccount(username).getPassword().equals(hash); 
    }
}