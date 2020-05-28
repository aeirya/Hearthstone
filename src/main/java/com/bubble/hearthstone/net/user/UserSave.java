package com.bubble.hearthstone.net.user;

import com.bubble.hearthstone.card.deck.Deck;
import com.bubble.hearthstone.card.deck.DeckCliView;
import com.bubble.hearthstone.model.shop.Wallet;
import com.bubble.hearthstone.util.serialize.Serializable;

public class UserSave implements Serializable {
    private final User user;
    private final Wallet wallet;
    private final UserInventory inventory;
    private Deck deck;
    
    public UserSave(User user) {
        this.user = user;
        this.deck = new Deck(user.getUsername());
        this.wallet = new Wallet();
        this.inventory = new UserInventory(deck);
    }
    
    public void selectDeck(Deck deck) {
        this.deck = deck;
        //call event
    }

    public Wallet getWallet() {
        return wallet;
    }

    public UserInventory getCollection() {
        return inventory;
        //returning deck for now, will have more options later
    }

    public Deck getCurrentDeck() {
        return deck;
    }

    public String getPrintedVersion() {
        return 
            "\nusername: " + user.getUsername() + "\n" + 
            "remaning gems: " + wallet.getGems() + "\n" +
            "\ncurrent deck: \n" + deck.getName() + "\n" +
            DeckCliView.makeTable(deck);
    }       
}
