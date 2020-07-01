package com.bubble.hearthstone.model.shop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.bubble.hearthstone.card.deck.Deck;
import com.bubble.hearthstone.card.deck.DeckCliView;
import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.card.registry.CardRegistry;
import com.bubble.hearthstone.net.user.UserInventory;
import com.bubble.hearthstone.util.resource.ResourceManager;

public class Shop {

    private final Collection<Deck> decks;
    private final CardRegistry registry;

    public Shop(ResourceManager resourceManager) {
        //better alternative the card registry gets its cards from resource manager
        this.registry = new CardRegistry(resourceManager);
        decks = new LinkedList<>();
        decks.add(
            new Deck(
                "all", registry.getCards()
            ));
    }

    public void purchase(Purchasable item, Wallet wallet, UserInventory collection) {
        final boolean result = wallet.purchase(item);
        if (result) collection.add(item);
    }

    public void sell(Purchasable item, Wallet wallet, UserInventory collection) {
        wallet.sell(item);
        collection.remove(item);
    }

    public CardRegistry getCardRegistry() {
        return registry;
    }

    public Collection<CardRecord> getAllCards() {
        return getCardRegistry().getCards();
    }

    public List<String> listDecks() {
        final List<String> list = new ArrayList<>();
        decks.forEach(deck -> list.add(DeckCliView.makeTable(deck)));
        return list;
    }
}