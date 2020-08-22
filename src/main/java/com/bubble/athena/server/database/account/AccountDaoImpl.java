package com.bubble.athena.server.database.account;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bubble.athena.server.database.PersistenceManager;

public class AccountDaoImpl implements AccountDao {
    private final PersistenceManager persistence;

    AccountDaoImpl(PersistenceManager persistence) {
        this.persistence = persistence;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Account> getAccounts() {
        EntityManager em = persistence.getEntityManager();
        Query query = em.createQuery("SELECT a FROM account a");
        return query.getResultList();
    }

    @Override
    public boolean saveAccount(Account account) {
        EntityManager em = persistence.getEntityManager();
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        return true;
    }

    public boolean deleteAccount(Account account) {
        EntityManager em = persistence.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(account) ? account : em.merge(account));
        em.getTransaction().commit();
        return true;
    }
}
