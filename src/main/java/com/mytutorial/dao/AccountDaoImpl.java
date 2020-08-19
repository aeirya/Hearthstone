package com.mytutorial.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.mytutorial.model.Account;
import com.mytutorial.util.PersistenceManager;

public class AccountDaoImpl implements AccountDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Account> getAccounts() {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        Query query = em.createQuery("SELECT a FROM account a");
        return query.getResultList();
    }

    @Override
    public boolean saveAccount(Account account) {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        return true;
    }

    public boolean deleteAccount(Account account) {
        EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
        em.getTransaction().begin();
        em.remove(account);
        em.getTransaction().commit();
        return true;
    }
}
