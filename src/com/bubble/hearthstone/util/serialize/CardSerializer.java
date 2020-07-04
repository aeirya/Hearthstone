package com.bubble.hearthstone.util.serialize;

import com.bubble.hearthstone.model.card.DummyCard;

public class CardSerializer extends GsonSerializer {
    
    public CardSerializer() {
        super();
    }

    public static void main(String[] args) {
        final CardSerializer cs = new CardSerializer();
        System.out.println(
            new DummyCard().serialize(cs)
        );
    }
}