package com.bubble.athena.server.database.card;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bubble.athena.server.database.PersistenceManager;

public class CardDaoImpl implements CardDao {

    private final EntityManager em;

    CardDaoImpl(PersistenceManager persistence) {
        em = persistence.getEntityManager();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Card> getCards() {
        Query query = em.createQuery("SELECT a FROM cards a");
        return query.getResultList();
    }

    @Override
    public boolean saveCard(Card card) {
        em.getTransaction().begin();
        em.persist(card);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public boolean deleteCard(Card card) {
        em.getTransaction().begin();
        em.remove(em.contains(card) ? card : em.merge(card));
        em.getTransaction().commit();
        return true;
    }
    
}