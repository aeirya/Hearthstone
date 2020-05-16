package com.bubble.hearthstone.net.event.events.shop;

import java.util.function.Consumer;

import com.bubble.hearthstone.controller.GameManager;
import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.model.shop.Wallet;
import com.bubble.hearthstone.net.user.User;
import com.bubble.hearthstone.util.resource.ResourceManager;
import com.bubble.hearthstone.util.services.ServiceLocator;

public abstract class ShopEvent implements IShopEvent {

    protected Consumer<GameManager> consumer;

    @Override
    public void process(GameManager manager) {
        consumer.accept(manager);
    }

    protected Shop getShop() {
        return ServiceLocator.getNetworkService().getShop();
    }

    protected Wallet getWallet(User user) {
        final ResourceManager res =  ServiceLocator.getResources();
        return res.loadSave(user).getWallet();
    }
}