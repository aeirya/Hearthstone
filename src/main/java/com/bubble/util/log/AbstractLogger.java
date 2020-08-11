package com.bubble.util.log;

/** wrapper of ILogger */
abstract class AbstractLogger implements ILogger {

    protected ILogger logger;

    public void set(String name) {
        logger.set(name);
    }

    public void log(String message) {
        logger.log(message);
    }

    public void log(LogLevel level, String message) {
        logger.log(level, message);
    }

    public void log(LogLevel level, String message, Throwable thrown) {
        logger.log(level, message, thrown);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void warning(String message) {
        logger.warning(message);
    }
}