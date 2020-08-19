package com.bubble.athena.server.database;

import com.bubble.athena.server.database.account.AccountManager;

public enum Database {
    INSTANCE;

    private final PersistenceManager persistence;
    private final AccountManager accountManager;

    private Database() {
        persistence = new PersistenceManager();
        accountManager = new AccountManager(persistence);
    }

    public void close() {
        persistence.close();
    }
    
    public static AccountManager getAccountManager() {
        return Database.INSTANCE.accountManager;
    }
}