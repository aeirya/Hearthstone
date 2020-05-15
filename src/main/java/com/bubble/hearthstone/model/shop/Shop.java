package com.bubble.hearthstone.model.shop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.bubble.hearthstone.card.deck.Deck;
// import com.bubble.hearthstone.util.services.ServiceLocator;

public class Shop {

    private final Collection<Deck> decks;

    public Shop() {
        decks = new LinkedList<>();
        decks.add(new Deck());
        decks.add(new Deck());
        //should be loading decks instead
    }

    public void purchase(Purchasable item, Wallet wallet) {
        wallet.purchase(item);
    }

    public void sell(Purchasable item, Wallet wallet) {
        wallet.sell(item);
    }

    public List<String> listDecks() {
        final List<String> list = new ArrayList<>();
        decks.forEach(deck -> list.add(Deck.makeTable(deck)));
        return list;
    }
}