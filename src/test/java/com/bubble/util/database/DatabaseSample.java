package com.bubble.util.database;

import com.bubble.athena.server.database.Database;

public class DatabaseSample {
    public static void main(String[] args) {
        new DatabaseSample().viewUsers();
    }
    
    public void createUsers() {
        Database.getAccountManager().create("aeirya", "password");
        Database.getAccountManager().create("ali", "password");
        Database.getAccountManager().create("ali", "password");
    }

    public void viewUsers() {
        System.out.println(Database.getAccountManager().getAccounts().toString());
    }
}