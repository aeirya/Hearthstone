package com.bubble.hearthstone.net2.user;

import com.bubble.hearthstone.card.deck.Deck;
import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.model.shop.Purchasable;

public class UserInventory {
    private final Deck deck;

    public UserInventory(Deck deck) {
        this.deck = deck;
    }

    public void add(Purchasable item) {
        if (item instanceof CardRecord) deck.addCard((CardRecord)item);
        else {
            //not implemented for other types yet
        }
    }

    public void remove(Purchasable item) {
        deck.removeCard((CardRecord)item);
    }
}