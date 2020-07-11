package com.bubble.hearthstone;

import com.bubble.hearthstone.model.card.ability.abilities.AttackEvent;
import com.bubble.hearthstone.model.card.monster.DummyMonster;
import com.bubble.hearthstone.module.event.EventSystem;
import com.bubble.hearthstone.module.event.IEvent;
import com.bubble.hearthstone.module.event.IEventHandler;
import com.bubble.hearthstone.module.gui.GuiEventHandler;
import com.bubble.hearthstone.module.gui.events.LaunchEvent;
import com.bubble.hearthstone.module.logic.arena.Arena;
import com.bubble.hearthstone.module.logic.arena.Match;
import com.bubble.hearthstone.module.management.ModuleManager;
import com.bubble.hearthstone.module.service.ServiceLocator;
import com.bubble.hearthstone.net.user.DummyUser;
import com.bubble.hearthstone.util.log.Log;
import com.bubble.hearthstone.util.time.Waiter;

public class Game implements IEventHandler <IEvent> {
    
    private final ModuleManager modules;
    private IEventHandler<IEvent> eventHandler;
    private boolean isRunning;
    
    public Game() {
        isRunning = true;
        modules = new ModuleManager(this);
        launchArena();
    }

    public void start() {
        modules.start();
        launchLoginScreen();
        mainLoop();
    }

    public void mainLoop() {
        while (isRunning) {
            updateGui();
            updateRenderer();
            Waiter.sleep();
        }
    }

    private void updateGui() {
        modules.getModules().getGui().update();
    }

    private void updateRenderer() {
        modules.getModules().getRenderer().update();
    }

    private void setEventHandler(IEventHandler<IEvent> handler) {
        this.eventHandler = handler;
    }

    public void launchLoginScreen() {
        // EventSystem.dispatch(
        //     new 
        // );   
        // EventSystem.dispatch(new LaunchEvent());
        new GuiEventHandler().handle(new LaunchEvent());
    }

    @Override
    public void handle(IEvent event) {
        eventHandler.handle(event);
    }

    public void launchArena() {
        Arena arena = new Match(
            ServiceLocator.getUserManager().getMe(),
            new DummyUser()
        ).createArena();
        setEventHandler(arena);
        arena.startSession();
        handle(
            new AttackEvent(
                new DummyMonster(), new DummyMonster())
        );
    }
}