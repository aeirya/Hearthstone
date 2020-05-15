package com.bubble.hearthstone.controller;

import com.bubble.hearthstone.interfaces.IInterpreter;
import java.util.Map;

public class MainMenuManager implements IInterpreter {

    public void interpret(String event) {
        map.get(event).run();
    }

    private static final
        Map <String, Runnable> map =
            Map.of(
                "Start",
                () -> {
                    
                }
                ,
                "See Decks",
                () -> {}
                ,
                "Profile",
                () -> {}
                ,            
                "Settings",
                () -> {}
                ,            
                "Quit",
                () -> {}
        );
}