
package com.bubble.util.database;

import com.bubble.athena.server.database.Database;

public class DeleteUserSample {

    public static void main(String[] args) {
        Database.getAccountManager().delete("aeiray");
        Database.getAccountManager().delete("aeirya");
        Database.getAccountManager().delete("ali");
        Database.getAccountManager().delete("ali");
        System.out.println(Database.getAccountManager().getAccounts());
    }
}