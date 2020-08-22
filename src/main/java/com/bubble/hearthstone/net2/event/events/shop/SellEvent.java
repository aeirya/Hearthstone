package com.bubble.hearthstone.net2.event.events.shop;

import com.bubble.hearthstone.model.shop.Purchasable;
import com.bubble.hearthstone.net2.user.User;

public class SellEvent extends ShopEvent {
    
    public SellEvent(Purchasable item, User user) {
        this.consumer = g ->
            getShop().sell(item, getWallet(user), getUserCollection(user));
    }
}