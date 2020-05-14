package com.bubble.hearthstone.card.registry;

import java.util.Map;

import com.bubble.hearthstone.card.Card;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class CardRegistry {
    private final Map<String, CardRecord> registry;
    
    private CardRegistry() {
        registry = ServiceLocator.getResources().getCards();
    }

    public Card get(String cardName) {
        return registry.get(cardName).copy();
    }
}