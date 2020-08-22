package com.bubble.athena.server.database.account;

import java.util.List;

public interface IAccountManager {
    List<Account> getAccounts();
    void create(String username, String password);
    void delete(String username);
}