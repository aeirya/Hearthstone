package com.bubble.hearthstone.ui;

import java.lang.reflect.InvocationTargetException;

import com.bubble.hearthstone.ui.cli.CliMainMenu;
import com.bubble.hearthstone.util.log.GameLogger;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class Cli implements IGameGraphics {

    private final GameLogger logger;
    private final MenuLuncher luncher;

    public Cli() {
        // logger = ServiceLocator.getLogger();
        logger = null;
        luncher = new CliMenuLuncher();
        lunch(MenuType.MAIN);
    }

    public static void main(String[] args) {
        new Cli();
    }

    public void update() {
        //
    }

    public void message(String message) {
        System.out.println(message);
        // logger.log(message);
    }

    public void error(String message) {
        logger.warning(message);
    }

    public void lunch(MenuType menu) {
        luncher.lunch(menu);
    }

    private void run(IMenu menu) {
        menu.lunch(this);
    }

    private final class CliMenuLuncher extends MenuLuncher {

        CliMenuLuncher() {
            super();
            init();
        }

        private void init() {
            mapper.put(MenuType.MAIN, CliMainMenu.class);
        }

        public void lunch(Class<? extends IMenu> clazz) {
            final IMenu menu = construct(clazz);
            run(menu);
        }

        private IMenu construct(Class<? extends IMenu> clazz) {
            try {
                return clazz.getConstructor().newInstance();
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException | NoSuchMethodException | SecurityException e) {
                ServiceLocator.getLogger().error(this, e);
            }
            return null;
        }
    }   
}