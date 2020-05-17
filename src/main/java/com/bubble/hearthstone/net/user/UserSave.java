package com.bubble.hearthstone.net.user;

import java.util.Collection;

import com.bubble.hearthstone.card.deck.Deck;
import com.bubble.hearthstone.model.shop.Purchasable;
import com.bubble.hearthstone.model.shop.Wallet;
import com.bubble.hearthstone.util.serialize.Serializable;

public class UserSave implements Serializable {
    private final User user;
    private Deck deck;
    private Wallet wallet;
    
    public UserSave(User user) {
        this.user = user;
        this.deck = new Deck(user.getUsername());
        this.wallet = new Wallet();
    }
    
    public void selectDeck(Deck deck) {
        this.deck = deck;
        //call event
    }

    public Wallet getWallet() {
        return wallet;
    }

    public Collection<Purchasable> getCollection() {
        return deck; 
        //returning deck for now, will have more options later
    }

    public String getPrintedVersion() {
        return 
            "\nusername: " + user.getUsername() + "\n" + 
            "remaning gems: " + wallet.getGems() + "\n" +
            "\ncurrent deck: \n" + deck.getName() + "\n" +
            Deck.makeTable(deck);
    }       
}
