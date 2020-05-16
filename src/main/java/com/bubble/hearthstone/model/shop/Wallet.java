package com.bubble.hearthstone.model.shop;

public class Wallet {
    private int gem = 0;
    
    public boolean purchase(Purchasable item) {
        final int value = item.getPrice();
        if (gem >= value) {
            gem -= value;
            //update collections
            return true;
        }
        else {
            //purchase could not be made
            return false;
        }
    }

    public void sell(Purchasable item) {
        final int value = item.getPrice();
        gem += value;
        //update collections
    }

    public String getGems() {
        return String.valueOf(gem);
    }
}