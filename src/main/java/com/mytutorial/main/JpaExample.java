package com.mytutorial.main;

import java.util.List;

import com.mytutorial.dao.AccountDao;
import com.mytutorial.dao.AccountDaoImpl;
import com.mytutorial.model.Account;
import com.mytutorial.util.PersistenceManager;

public class JpaExample {

	public static void main(String[] args) {
        
		AccountDao dao = new AccountDaoImpl();
        List<Account> accounts = dao.getAccounts();
        System.out.println(accounts);
        
        Account acc = new AccountCreator().setName("aeirya").setPassword("password").build();
        dao.saveAccount(acc);
        accounts = dao.getAccounts();
        System.out.println(accounts);
        
        PersistenceManager.INSTANCE.close();
	}
}

