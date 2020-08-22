package com.bubble.hearthstone.net2.event.events.shop;

import com.bubble.hearthstone.model.shop.Purchasable;
import com.bubble.hearthstone.net2.user.User;

public class BuyEvent extends ShopEvent {
    
    //should i maybe user user save?
    //or even bettter, an IPurchaser interface
    public BuyEvent(Purchasable item, User user) {
        this.consumer = g ->
            getShop().purchase(item, getWallet(user), getUserCollection(user) );
    }
}