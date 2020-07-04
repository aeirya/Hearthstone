package com.bubble.hearthstone.model.card.registry;

import java.util.Collection;
import java.util.Map;

import com.bubble.hearthstone.model.card.Card;
import com.bubble.hearthstone.util.resource.ResourceManager;

public class CardRegistry {
    private final Map<String, Card> registry;
    
    public CardRegistry(ResourceManager resourceManager) {
        registry = resourceManager.getCards();
    }

    public Card get(String cardName) {
        return registry.get(cardName);
    }

    public Collection<Card> getCards() {
        return registry.values();
    }
}