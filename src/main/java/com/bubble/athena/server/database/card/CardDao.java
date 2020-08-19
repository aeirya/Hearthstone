package com.bubble.athena.server.database.card;

import java.util.List;

public interface CardDao {
    List<Card> getCards();
    boolean saveCard(Card card);
    boolean deleteCard(Card card);
}