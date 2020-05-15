package com.bubble.hearthstone.model.shop;

import java.util.Collection;

import com.bubble.hearthstone.card.deck.Deck;

public class Shop {

    Collection<Deck> decks;

    public void purchase(Purchasable item, Wallet wallet) {
        wallet.purchase(item);
    }

    public void sell(Purchasable item, Wallet wallet) {
        wallet.sell(item);
    }
}