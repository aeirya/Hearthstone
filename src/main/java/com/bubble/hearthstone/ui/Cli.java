package com.bubble.hearthstone.ui;

import java.lang.reflect.InvocationTargetException;

import com.bubble.hearthstone.input.IGameInput;
import com.bubble.hearthstone.ui.cli.CliLoginMenu;
import com.bubble.hearthstone.ui.cli.CliMainMenu;
import com.bubble.hearthstone.ui.cli.CliMenu;
import com.bubble.hearthstone.ui.cli.CliShopMenu;
import com.bubble.hearthstone.util.log.GameLogger;
import com.bubble.hearthstone.util.services.ServiceLocator;

public class Cli implements IGameGraphics {

    private final GameLogger logger;
    private final MenuLauncher luncher;
    private CliMenu currentMenu;

    public Cli() {
        logger = ServiceLocator.getLogger();
        luncher = new CliMenuLuncher();
        this.launch(MenuType.LOGIN);
    }

    public void update() {
        //
    }

    public void message(String message) {
        logger.log(message);
    }

    public void error(String message) {
        logger.warning(message);
    }

    public void launch(MenuType menu) {
        luncher.launch(menu);
    }

    public void load(CliMenu menu) {
        this.currentMenu = menu;
    }

    private final class CliMenuLuncher extends MenuLauncher {

        CliMenuLuncher() {
            super();
            init();
        }

        //hey, don't forget to add all your menus here!
        private void init() {
            mapper.put(MenuType.MAIN, CliMainMenu.class);
            mapper.put(MenuType.LOGIN, CliLoginMenu.class);
            mapper.put(MenuType.SHOP, CliShopMenu.class);
        }

        public void launch(Class<? extends IMenu> clazz) {
            final IMenu menu = construct(clazz);
            if (menu != null) run(menu);
        }

        private void run(IMenu menu) {
            menu.launch(Cli.this);
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

    @Override
    public void showHelp() {
        currentMenu.printCommands();
    }

    @Override
    public IMenu getCurrentMenu() {
        return currentMenu;
    }

    @Override
    public void bind(IGameInput graphics) {
        // TODO Auto-generated method stub

    }
}