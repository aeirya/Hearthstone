package com.bubble.hearthstone.net.client;

import com.bubble.hearthstone.controller.GuiManager;
import com.bubble.hearthstone.interfaces.Updatable;
import com.bubble.hearthstone.net.INetworkService;
import com.bubble.hearthstone.net.event.EventHandler;
import com.bubble.hearthstone.net.event.GameEventHandler;
import com.bubble.hearthstone.net.event.IEventProcessor;
import com.bubble.hearthstone.net.event.IGameEvent;
import com.bubble.hearthstone.net.event.events.IClientEvent;
import com.bubble.hearthstone.net.event.events.IGuiEvent;
import com.bubble.hearthstone.ui.GraphicsMode;
import com.bubble.hearthstone.ui.MenuType;
import com.bubble.hearthstone.util.net.module.INetwork;
import com.bubble.hearthstone.util.net.module.IRequest;
import com.bubble.hearthstone.util.net.module.IResponse;
import com.bubble.hearthstone.util.services.ModuleLocator;
import com.bubble.hearthstone.util.services.ModuleManager;
import com.bubble.hearthstone.util.services.ServiceLocator;
import com.bubble.hearthstone.util.time.Waiter;

public class GameClient implements Updatable, IEventProcessor {
    private final ModuleManager moduleManager;
    private final GuiManager guiManager;
    private final INetworkService network;
    private final EventHandler eventHandler;
    private final INetwork networkRequestModule;

    public GameClient(GraphicsMode graphicsMode) {
        moduleManager = new ModuleManager(graphicsMode);
        guiManager = new GuiManager(
            ModuleLocator.getGameInput(),
            ModuleLocator.getGraphics());
        network = connect();
        eventHandler = new GameEventHandler(this, null).start();
        networkRequestModule = null;
    }

    private INetworkService connect() {
        return ServiceLocator.getNetworkService().connect();
    }

    public void start() {
        moduleManager.start();
        guiManager.start();
    }

    public void networkPush(IGameEvent event) {
        network.push(event);
    }

    public void clientPush(IGameEvent event) {
        eventHandler.receive(event);
    }

    /** pushes event to the proper event queue */
    public void handleEvent(IGameEvent event) {
        if (event instanceof IClientEvent) {
            this.clientPush(event);
        }
        else {
            this.networkPush(event);
        }
    }

    public void handleGuiEvent(IGuiEvent event) {
        guiManager.handleEvent(event);
    }

    public IResponse sendRequest(IRequest request) {
        return networkRequestModule.sendRequest(request);
    }

    public void prompt(String message) {
        ModuleLocator
            .getGraphics()
            .message(message);
    }

    public void launch(MenuType menu) {
        ModuleLocator
            .getGraphics()
            .launch(menu);
    }

    public void update() {
        receiveEvents();
        //do render
        Waiter.sleep();
    }

    private void receiveEvents() {
        while (network.hasNext())
        {
            final IGameEvent event = network.get();
            eventHandler.receive(event);
        }
    }

    public void printBroadcastMessage(String message) {
        ServiceLocator.getLogger().log("broadcast message: " + message);
    }
}