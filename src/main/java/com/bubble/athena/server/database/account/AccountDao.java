package com.bubble.athena.server.database.account;
 
import java.util.List;
 
public interface AccountDao {
    public List<Account> getAccounts();
 
    public boolean saveAccount(Account account);
    
    public boolean deleteAccount(Account account);
}
 
