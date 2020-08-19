package com.mytutorial.dao;
 
import java.util.List;
 
import com.mytutorial.model.Account;
 
public interface AccountDao {
    public List<Account> getAccounts();
 
    public boolean saveAccount(Account account);
    public boolean deleteAccount(Account account);
}
 
