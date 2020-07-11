package com.bubble.hearthstone.module.management;

import com.bubble.hearthstone.module.input.GameInput;
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

    private final GameInput input;
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
    
        gui = initiateGuiManager();
        input = initiateInput();
        renderer = initiateRenderer();
        graphics = initiateGraphics();

        locator = initiateModuleLocator();
        eventBus = initiateEventBus(game);
        eventManager = initiateEventManager();
    }

    private final ModuleLocator initiateModuleLocator() {
        return ModuleLocator
            .provideInstance(new ModuleLocator())
            .provideGui(gui)
            .provideRenderer(renderer)
            .provideLogic(game);
    }

    private final EventBus initiateEventBus(Game game) {
        return new EventBus(null);
    }

    private final IGraphics initiateGraphics() {
        return new OpenGlGraphics(renderer, gui);
    }

    private final IRenderer initiateRenderer() {
        return new Renderer();
    }

    private final GameInput initiateInput() {
        return new GameInput(gui);
    }

    private final GuiManager initiateGuiManager() {
        return new GuiManager();
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
        gui.start();
        input.start();
        graphics.start();
        renderer.start();
        // start components
        // network.start();
    }
}