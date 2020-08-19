package com.bubble.athena.server.database;

import com.bubble.athena.server.database.account.AccountManager;
import com.bubble.athena.server.database.account.IAccountManager;
import com.bubble.athena.server.database.card.CardManager;

public enum Database {
    INSTANCE;

    private final PersistenceManager persistence;
    private final IAccountManager accountManager;
    private final CardManager cardManager;

    private Database() {
        persistence = new PersistenceManager();
        accountManager = new AccountManager(persistence);
        cardManager = new CardManager(persistence);
    }

    public void close() {
        persistence.close();
    }
    
    public static IAccountManager getAccountManager() {
        return Database.INSTANCE.accountManager;
    }

    public static CardManager getCardManager() {
        return Database.INSTANCE.cardManager;
    }
}