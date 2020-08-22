package com.bubble.athena.server.database.card;

import java.util.List;

import com.bubble.athena.server.database.PersistenceManager;

public class CardManager {
    private final CardDao dao;

    public CardManager(PersistenceManager persistence) {
        dao = new CardDaoImpl(persistence);
    }

    public void saveCard(Card card) {
        dao.saveCard(card);
    }

    public List<Card> getAllCards() {
        return dao.getCards();
    }
}