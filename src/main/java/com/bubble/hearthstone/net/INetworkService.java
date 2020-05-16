package com.bubble.hearthstone.net;

import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.net.user.User;

public interface INetworkService {
    void connect();
    Shop getShop();
    User getMe();
    void login(User user);
}