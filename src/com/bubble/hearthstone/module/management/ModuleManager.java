package com.bubble.hearthstone.module.management;

import com.bubble.hearthstone.module.input.GameInput;
import com.bubble.hearthstone.module.input.IInput;
import com.bubble.hearthstone.Game;
import com.bubble.hearthstone.module.event.EventBus;
import com.bubble.hearthstone.module.event.EventManager;
import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.graphics.IGraphics;
import com.bubble.hearthstone.module.graphics.OpenGlGraphics;
import com.bubble.hearthstone.module.gui.GuiManager;
import com.bubble.hearthstone.module.render.IRenderer;
import com.bubble.hearthstone.module.render.opengl.Renderer;

public class ModuleManager {
    
    private final EventBus eventBus;

    private final IInput input;
    private final IRenderer renderer;
    private final IGraphics graphics;

    private final EventManager eventManager;
    private final EventSystem eventSystem;

    private final GuiManager gui;
    private final ModuleLocator locator;

    private final Game game;

    public ModuleManager(Game game) {
        this.game = game;
        
        eventSystem = initiateEventSystem();
    
        renderer = initiateRenderer();
        gui = initiateGuiManager();
        input = initiateInput();
        graphics = initiateGraphics();

        locator = initiateModuleLocator();
        eventBus = initiateEventBus();
        eventManager = initiateEventManager();
    }

    private final ModuleLocator initiateModuleLocator() {
        return ModuleLocator
            .provideInstance(new ModuleLocator())
            .provideGui(gui)
            .provideLogic(game);
    }

    private final EventBus initiateEventBus() {
        return new EventBus(null);
    }

    private final IGraphics initiateGraphics() {
        return new OpenGlGraphics(renderer, gui);
    }

    private final IRenderer initiateRenderer() {
        return new Renderer();
    }

    private final IInput initiateInput() {
        return new GameInput(gui.getFrame());
    }

    private final GuiManager initiateGuiManager() {
        return new GuiManager(input);
    }

    private final EventSystem initiateEventSystem() {
        return new EventSystem(eventManager);
    }

    private final EventManager initiateEventManager() {
        return new EventManager(locator, eventBus);
    }

    public ModuleLocator getModules() {
        return locator;
    }

    private void initiateEngine() {
        EventSystem.start(eventSystem);
    }

    public void start() {
        initiateEngine();
        renderer.start();
        gui.start();
        graphics.start();
        // start components
        input.start();
        // network.start();
    }
}