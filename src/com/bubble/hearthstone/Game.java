package com.bubble.hearthstone;

import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.event.IEventHandler;
import com.bubble.hearthstone.module.gui.GuiEventHandler;
import com.bubble.hearthstone.module.gui.events.LaunchEvent;
import com.bubble.hearthstone.module.logic.arena.Arena;
import com.bubble.hearthstone.module.management.ModuleManager;
import com.bubble.hearthstone.util.time.Waiter;

public class Game implements IEventHandler {
    
    private final ModuleManager modules;
    private IEventHandler eventHandler;
    private boolean isRunning;
    
    public Game() {
        isRunning = true;
        modules = new ModuleManager(this);
    }

    public void start() {
        modules.start();
        launchLoginScreen();
        // mainLoop();
    }

    public void mainLoop() {
        while (isRunning) {
            updateGui();
            Waiter.sleep();
        }
    }

    private void updateGui() {
        modules.getModules().getGui().update();
    }

    private void setEventHandler(IEventHandler handler) {
        this.eventHandler = handler;
    }

    public void launchLoginScreen() {
        // EventSystem.dispatch(
        //     new 
        // );   
        new GuiEventHandler().handle(new LaunchEvent());
    }

    public void launchArena() {
        Arena arena = new Arena();
        setEventHandler(arena);
        arena.startSession();
    }
}