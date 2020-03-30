package ui.cli;

import dev.JavaUtilLogger;

public class CliManager implements ui.IUiManager {

    public CliManager() {
        JavaUtilLogger.setLogger(this.getClass().getName());
    }

    public void show() {
        JavaUtilLogger.debugLog("test");
    }
}