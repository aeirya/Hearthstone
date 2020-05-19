package com.bubble.hearthstone.controller;

import com.bubble.hearthstone.net.INetworkService;
import com.bubble.hearthstone.net.event.EventHandler;
import com.bubble.hearthstone.net.event.GameEventHandler;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.BroadcastMessageEvent;
import com.bubble.hearthstone.net.event.events.IClientEvent;
import com.bubble.hearthstone.net.user.UserManager;
import com.bubble.hearthstone.ui.IGameGraphics;
import com.bubble.hearthstone.ui.MenuType;
import com.bubble.hearthstone.util.services.ServiceLocator;

//will probably connect interfaces with event handler..
public class GameManager {
    
    private final UserManager userManager;
    private final EventHandler eventHandler;
    private final INetworkService network;
    private final IGameGraphics graphics;

    public GameManager(IGameGraphics graphics) {
        this.network = ServiceLocator.getNetworkService().connect();
        this.userManager = new UserManager(this);
        this.eventHandler = new GameEventHandler(this, userManager).start();
        this.graphics = graphics;
    }

    public boolean login(String username, String password) {
        return userManager.login(username, password);
    }

    public boolean signup(String username, String password) {
        return userManager.signup(username, password);
    }

    public boolean deleteUser(String username, String password) {
        return userManager.deleteUser(username, password);
    }
    
    public void logout() {
        userManager.logout();
    }

    public void printBroadcastMessage(String message) {
        ServiceLocator.getLogger().log("broadcast message: " + message);
    }

    public void broadcast(String message) {
        network.push(
            new BroadcastMessageEvent(message)
        );
    }

    public void update() {
        //i guess i should start using threads
        final IGameEvent event = network.get();
        eventHandler.receive(event);
    }

    /** pushes event to the proper event queue */
    public void handleEvent(IGameEvent e) {

        if (e instanceof IClientEvent) this.clientPush(e);
        else this.networkPush(e);

        //خود این کد واضحه
        //این خوبه؟
        // if (e instanceof IClientEvent) userManager.handle(e);


        // map / Enumeration
        // enum -> handler

        


        //redirect کنم دستورا رو
        //به عاملان مخصوص خودش

        
        
        //همین الانم همین کار رو میکنم...
        //ولی یه لول بالاترش رو میخوام

        //که 



        //

        // else networkPush(e);
    }

    public void networkPush(IGameEvent event) {
        network.push(event);
    }

    public void clientPush(IGameEvent event) {
        eventHandler.receive(event);
    }

    public void message(String message) {
        graphics.message(message);
    }

    public void lunch(MenuType menu) {
        graphics.lunch(menu);
    }

    //The part I really hate: getter, setters
    public UserManager getUserManager() {
        return userManager;
    }

    public IGameGraphics getGraphics() {
        return graphics;
    }
}
