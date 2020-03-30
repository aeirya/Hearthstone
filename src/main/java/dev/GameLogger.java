package dev;

/**
 * GameLogger
 */
public class GameLogger implements IGameLogger {
    private ILogger logger;
    
    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    public ILogger getLogger() {
        return logger;
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void debug(Log log) {
        logger.debug(log.toString());
    }
}