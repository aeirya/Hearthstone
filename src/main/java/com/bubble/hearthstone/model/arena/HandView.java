package com.bubble.hearthstone.model.arena;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;

import com.bubble.hearthstone.card.registry.CardRecord;
import com.bubble.hearthstone.interfaces.Drawable;

public class HandView implements Drawable {

    private final Hand hand;
    private final ArenaPanelConfig config;
    private final Dimension screensize;

    public HandView(Hand hand, ArenaPanelConfig config, Dimension screensize) {
        this.hand = hand;
        this.config = config;
        this.screensize = screensize;
    }

    @Override
    public void draw(Graphics g) {
        final Dimension cardSize = config.getCardSize(screensize, hand.getCardsInHand().size());
        final CardRecord card = new CardRecord();
        final int y = config.getHandSpawnY(screensize, hand.getCardsInHand().size());
        getCardSpawnX(cardSize).forEach(x -> {
            final CardRecord copy = card.copy();
            copy.setLocation(x,y);
            copy.draw(g);
        });
    }

    private List<Integer> getCardSpawnX(Dimension cardSize) {
        final int n = hand.getCardsInHand().size();
        final int spaceUsedByCards = cardSize.width * n;
        final int spacing = (screensize.width - spaceUsedByCards) / (n + 1);
        final List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(i * spacing + (i - 1) * cardSize.width);
        }
        return result;
    }
}