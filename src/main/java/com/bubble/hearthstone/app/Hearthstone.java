package com.bubble.hearthstone.app;

import com.bubble.hearthstone.net2.INetworkService;
import com.bubble.hearthstone.net2.NetworkService;
import com.bubble.hearthstone.ui.GraphicsMode;
import com.bubble.hearthstone.util.config.ConfigLoader;
import com.bubble.hearthstone.util.log.ColoredGameLogger;
import com.bubble.hearthstone.util.log.GameLogger;
import com.bubble.hearthstone.util.resource.ResourceManager;
import com.bubble.hearthstone.util.services.ServiceLocator;
import java.awt.EventQueue;
import java.util.Properties;

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
        new ServiceInitializer().initialize();
        /*
        * fixed bug: GameEventHandler needs to register a logger upon initializations
        */
        final Game game = new Game(GraphicsMode.SWING);
        EventQueue.invokeLater(
            game::start
            );
        while (!quit) game.update();
    }
    
    public static void quit() {
        quit = true;
        System.exit(0);
    }
    
    private class ServiceInitializer {
        private void initialize() {
            final GameLogger logger = new ColoredGameLogger();
            final Properties resourceConfig = findConfig(config);
            //dependency here should be inversed
            final ResourceManager resourceManager = new ResourceManager(resourceConfig);
            final INetworkService networkService = new NetworkService(resourceManager);
            initiateServiceLocator(logger, resourceManager, networkService);   
        }

        private Properties findConfig(String path) {
            return new ConfigLoader().loadFile(
                this.getClass().getClassLoader().getResource(path).getFile()
            );
        }
    
        private void initiateServiceLocator(GameLogger logger, ResourceManager resourceManager, INetworkService networkService) {
            ServiceLocator.getInstance()
                .provideLogger(logger)
                .provideResources(resourceManager)
                .provideNetworkService(networkService);
        }
    }
}