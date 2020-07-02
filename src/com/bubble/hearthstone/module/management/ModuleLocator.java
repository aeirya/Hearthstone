package com.bubble.hearthstone.module.management;

import com.bubble.hearthstone.module.render.IRenderer;

import java.util.ArrayList;
import java.util.List;

import com.bubble.hearthstone.module.IFramework;
import com.bubble.hearthstone.module.event.EventManager;
import com.bubble.hearthstone.module.gui.GuiManager;

public class ModuleLocator {

    private final List<IFramework> modules;
    private GuiManager gui;
    private EventManager eventManager;

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

    public static EventManager getEventManager() {
        return getInstance().eventManager;
    }

    public List<IFramework> getAll() {
        return modules;
    }
}