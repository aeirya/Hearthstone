package ui.cli;

public class CliManager implements ui.IUiManager {

    dev.ILogger logger;

    public CliManager() {
        logger = new dev.JavaUtilLogger(this.getClass());
    }

    public void show() {
        logger.debug("started CLI manager");
    }
}