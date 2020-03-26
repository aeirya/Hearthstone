package app;

import ui.IUiManager;
import ui.cli.CliManager;

/**
 * GameManager is responsible for managing the game, alongside the other
 * managers which is controlled by it
 */
public class GameManager {
    private static GameManager instance;
    private IUiManager uiManager;
    private Boolean consoleMode;

    private GameManager(Boolean consoleMode) {
        this.consoleMode = consoleMode;
        initialize();
        run();
    }
    
    private GameManager() {
        this(true);
    }
    
    private void initialize() {
        if (consoleMode) {
            uiManager = new CliManager();
        }
    }

    private void run() {
        uiManager.show();
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public IUiManager getUiManager() {
        return uiManager;
    }
}