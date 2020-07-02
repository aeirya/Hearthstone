package com.bubble.hearthstone.module.management;

import com.bubble.hearthstone.module.input.IInput;
import com.bubble.hearthstone.module.gui.GuiManager;
import com.bubble.hearthstone.module.render.IRenderer;
import com.bubble.hearthstone.module.render.opengl.Renderer;
import com.bubble.hearthstone.message.EventBus;

public class ModuleManager {
    
    private final EventBus messageBus;

    private final IInput input;
    private final IRenderer renderer;
    
    private final GuiManager gui;
    private final ModuleLocator locator;

    public ModuleManager() {
        messageBus = initiateMessageBus();
        // use an event system file instead?
        
        input = initiateInput();
        renderer = initiateRenderer();

        gui = initiateGuiManager();
        locator = initiateModuleLocator();
    }

    private final ModuleLocator initiateModuleLocator() {
        return new ModuleLocator()
                    .provideGui(gui);
    }

    private final EventBus initiateMessageBus() {
        return new EventBus();
    }

    private final IRenderer initiateRenderer() {
        return new Renderer();
    }

    private final IInput initiateInput() {
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