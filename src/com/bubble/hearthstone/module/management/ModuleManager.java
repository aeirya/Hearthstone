package com.bubble.hearthstone.module.management;

import com.bubble.hearthstone.module.input.IInput;
import com.bubble.hearthstone.module.event.EventManager;
import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.graphics.IGraphics;
import com.bubble.hearthstone.module.graphics.OpenGlGraphics;
import com.bubble.hearthstone.module.gui.GuiManager;
import com.bubble.hearthstone.module.render.IRenderer;
import com.bubble.hearthstone.module.render.opengl.Renderer;
import com.bubble.hearthstone.message.EventBus;

public class ModuleManager {
    
    private final EventBus messageBus;

    private final IInput input;
    private final IRenderer renderer;
    private final IGraphics graphics;

    private final EventManager eventManager;
    private final EventSystem eventSystem;

    private final GuiManager gui;
    private final ModuleLocator locator;

    public ModuleManager() {
        messageBus = initiateEventBus();
        // use an event system file instead?
        
        renderer = initiateRenderer();
        input = initiateInput();
        graphics = initiateGraphics();

        gui = initiateGuiManager();
        
        locator = initiateModuleLocator();
    }

    private final ModuleLocator initiateModuleLocator() {
        return ModuleLocator
            .provideInstance(new ModuleLocator())
            .provideGui(gui);
    }

    private final EventBus initiateEventBus() {
        return new EventBus();
    }

    private final IGraphics initiateGraphics() {
        return new OpenGlGraphics();
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