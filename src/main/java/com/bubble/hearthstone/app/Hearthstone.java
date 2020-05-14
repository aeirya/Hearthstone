package com.bubble.hearthstone.app;

import com.bubble.hearthstone.app.Game.GraphicsMode;
import com.bubble.hearthstone.util.log.ColoredGameLogger;
import com.bubble.hearthstone.util.log.GameLogger;
import com.bubble.hearthstone.util.resource.ResourceManager;
import com.bubble.hearthstone.util.services.ServiceLocator;
import java.awt.EventQueue; 

public class Hearthstone implements Runnable {

    private static boolean quit = false;
    private final String config;

    public static void main(String[] args) {
        new Hearthstone(args).run();
    }

    private Hearthstone(String[] args) {
        if (args.length > 0) {
            config = args[0];
        }
        else config = "config/files.properties";
    }

    public void run()
    {
        initiateServiceLocator();   
        /*
        * fixed bug: GameEventHandler needs to register a logger upon initializations
        */
        final Game game = new Game(GraphicsMode.CLI);
        EventQueue.invokeLater(
            () -> {
                game.start();
            }
            );
        while (!quit) game.update();
    }
        
    private void initiateServiceLocator() {
        final GameLogger logger = new ColoredGameLogger();
        final ResourceManager resourceManager = new ResourceManager(config);
        ServiceLocator.getInstance()
            .provideLogger(logger)
            .provideResources(resourceManager);
    }

    public static void quit() {
        quit = true;
    }
}