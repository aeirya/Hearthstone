package com.bubble.hearthstone.card.registry;

import java.util.Collection;
import java.util.Map;

import com.bubble.hearthstone.card.Card;
import com.bubble.hearthstone.util.resource.ResourceManager;

public class CardRegistry {
    private final Map<String, CardRecord> registry;
    
    public CardRegistry(ResourceManager resourceManager) {
        registry = resourceManager.getCards();
    }

    public Card get(String cardName) {
        return registry.get(cardName).copy();
    }

    public Collection<CardRecord> getCards() {
        return registry.values();
    }
}