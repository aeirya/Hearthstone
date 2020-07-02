package com.bubble.hearthstone.module.management;

import com.bubble.hearthstone.module.render.IRenderer;

import java.util.ArrayList;
import java.util.List;

import com.bubble.hearthstone.Game;
import com.bubble.hearthstone.module.IFramework;
import com.bubble.hearthstone.module.event.EventManager;
import com.bubble.hearthstone.module.graphics.IGraphics;
import com.bubble.hearthstone.module.gui.GuiManager;

public class ModuleLocator {

    private final List<IFramework> modules;
    private GuiManager gui;
    private IGraphics graphics;
    private EventManager eventManager;
    private Game game;

    ModuleLocator() {
        modules = new ArrayList<>();
    }

    private static class InstanceHolder {
        private static ModuleLocator instance;
    }

    static ModuleLocator provideInstance(ModuleLocator instance) {
        InstanceHolder.instance = instance;
        return instance;
    }

    private static ModuleLocator getInstance() {
        return InstanceHolder.instance;
    }

    public IRenderer getRenderer() {
        return null;
    }

    ModuleLocator provideGui(GuiManager gui) {
        this.gui = gui;
        modules.add(gui);
        return this;
    }

    public GuiManager getGui() {
        return gui;
    }

    ModuleLocator provideEventManager(EventManager eventManager) {
        this.eventManager = eventManager;
        return this;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    ModuleLocator provideGraphics(IGraphics graphics) {
        this.graphics = graphics;
        modules.add(graphics);
        return this;
    }

    public IGraphics getGraphics() {
        return graphics;
    }

    ModuleLocator provideLogic(Game game) {
        this.game = game;
        return this;
    }

    public Game getLogic() {
        return game;
    }

    public List<IFramework> getAll() {
        return modules;
    }
}