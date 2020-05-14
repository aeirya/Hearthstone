package com.bubble.hearthstone.net.user;

import com.bubble.hearthstone.card.deck.Deck;
import com.bubble.hearthstone.util.serialize.Serializable;

public class UserSave implements Serializable {
    private final User user;
    private Deck deck;
    private int gem;
    
    public UserSave(User user) {
        this.user = user;
        this.gem = 0;
    }
    
    void selectDeck(Deck deck) {
        this.deck = deck;
        //call event
    }
}