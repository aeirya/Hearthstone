package com.bubble.hearthstone.model.shop;

import java.util.Collection;
import java.util.LinkedList;

import com.bubble.hearthstone.card.deck.Deck;

public class Shop {

    private final Collection<Deck> decks;

    public Shop() {
        decks = new LinkedList<>();
        //should be loading decks instead
    }

    public void purchase(Purchasable item, Wallet wallet) {
        wallet.purchase(item);
    }

    public void sell(Purchasable item, Wallet wallet) {
        wallet.sell(item);
    }
}