package com.bubble.hearthstone.model.shop;

public class Wallet {
    private int gem = 0;
    
    public void purchase(Purchasable item) {
        final int value = item.getPrice();
        if (gem >= value) {
            gem -= value;
            //update collections
        }
        else {
            //purchase could not be made
        }
    }

    public void sell(Purchasable item) {
        final int value = item.getPrice();
        gem += value;
        //update collections
    }
}