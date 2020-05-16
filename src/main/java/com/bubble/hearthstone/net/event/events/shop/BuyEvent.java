package com.bubble.hearthstone.net.event.events.shop;

import com.bubble.hearthstone.model.shop.Purchasable;
import com.bubble.hearthstone.net.user.User;

public class BuyEvent extends ShopEvent {
    
    //should i maybe user user save?
    //or even bettter, an IPurchaser interface
    public BuyEvent(Purchasable item, User user) {
        this.consumer = g ->
            getShop().purchase(item, getWallet(user));
    }
}