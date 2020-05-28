package com.bubble.hearthstone.net;

import com.bubble.hearthstone.controller.Arena;
import com.bubble.hearthstone.controller.GameSession;
import com.bubble.hearthstone.model.shop.Shop;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.user.User;

public interface INetworkService {
    INetworkService connect();
    
    GameSession startGameSession();
    Shop getShop();
    Arena getArena();
    User getMe();
    void login(User user);

    IGameEvent get();
    void push(IGameEvent event);
}