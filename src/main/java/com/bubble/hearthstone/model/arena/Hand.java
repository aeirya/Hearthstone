package com.bubble.hearthstone.model.arena;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.bubble.hearthstone.card.deck.Deck;
import com.bubble.hearthstone.card.registry.CardRecord;

//todo: merge with player
public class Hand {
    private final Deck deck;
    private final LinkedList<CardRecord> queue;
    private final List<CardRecord> cardsInHand;

    public Hand(Deck deck) {
        this.deck = deck;
        this.cardsInHand = new ArrayList<>();
        this.queue = new LinkedList<>(
            deck.getCards().stream().map(CardRecord::copy).collect(Collectors.toList())
        );
    }

    public List<CardRecord> shuffle(List<CardRecord> cardRecord) {
        return cardRecord;
    }

    public List<CardRecord> getCardsInHand() {
        return cardsInHand;
    }

    public CardRecord drawCard() {
        final CardRecord next = queue.removeLast();
        cardsInHand.add(next);
        return next;
    }
} 