package com.bubble.hearthstone.client.service.module;

import com.bubble.hearthstone.client.framework.input.IInput;
import com.bubble.hearthstone.client.framework.network.INetwork;
import com.bubble.hearthstone.client.service.gui.GuiManager;
import com.bubble.hearthstone.client.service.render.IRenderer;
import com.bubble.hearthstone.client.service.render.lwjgl.LwjglRenderer;
import com.bubble.hearthstone.message.MessageBus;

public class ModuleManager {
    
    private final MessageBus messageBus;

    private final IInput input;
    private final IRenderer renderer;
    private final INetwork network;
    
    private final GuiManager gui;
    private final ModuleLocator locator;

    public ModuleManager() {
        messageBus = initiateMessageBus();
        // use an event system file instead?
        
        input = initiateInput();
        renderer = initiateRenderer();
        network = initiateNetwork();

        gui = initiateGuiManager();
        locator = initiateModuleLocator();
    }

    private final ModuleLocator initiateModuleLocator() {
        return new ModuleLocator()
                    .provideNetwork(network);
    }

    private final MessageBus initiateMessageBus() {
        return new MessageBus();
    }

    private final IRenderer initiateRenderer() {
        return new LwjglRenderer();
    }

    private final IInput initiateInput() {
        return null;
    }

    private final INetwork initiateNetwork() {
        return null;
    }

    private final GuiManager initiateGuiManager() {
        return new GuiManager();
    }

    public ModuleLocator getModules() {
        return locator;
    }

    public void start() {
        // start components
        
        // input.start();
        // renderer.start();
        // network.start();
        // gui.start();
    }
}