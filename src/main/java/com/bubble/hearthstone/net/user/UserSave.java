package com.bubble.hearthstone.net.user;

import com.bubble.hearthstone.card.deck.Deck;
import com.bubble.hearthstone.model.shop.Wallet;
import com.bubble.hearthstone.util.serialize.Serializable;

public class UserSave implements Serializable {
    private final User user;
    private Deck deck;
    private Wallet wallet;
    
    public UserSave(User user) {
        this.user = user;
        wallet = new Wallet();
        deck = new Deck();
    }
    
    public void selectDeck(Deck deck) {
        this.deck = deck;
        //call event
    }
}