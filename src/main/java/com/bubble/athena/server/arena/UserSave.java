package com.bubble.athena.server.arena;

public class UserSave {
    // private final Wallet wallet;
    // private final UserInventory inventory;
    private IDeck currentDeck;   
    private IHero currentHero;

    public IDeck getCurrentDeck() {
        return currentDeck;
    }

    public IHero getCurrentHero() {
        return currentHero;
    }
}