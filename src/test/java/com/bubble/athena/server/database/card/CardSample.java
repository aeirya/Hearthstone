package com.bubble.athena.server.database.card;

import java.util.List;

import com.bubble.athena.game.card.CardRarity;
import com.bubble.athena.game.card.CardType;
import com.bubble.athena.server.database.Database;

public class CardSample {
    public static void main(String[] args) {
        new CardSample().load();
    }
    
    CardManager cards;

    public CardSample() {
        cards = Database.getCardManager();
    }
    
    public void load() {
        List<Card> c = cards.getAllCards();
        System.out.println(c);
    }

    public void addRow() {
        Card card = new Card();
        card.setName("goody card");
        card.setMana(1);
        card.setType(CardType.MINION);
        card.setRarity(CardRarity.STARTER);
        card.setHealth(3);
        card.setDamage(1);
        cards.saveCard(card);
    }
}