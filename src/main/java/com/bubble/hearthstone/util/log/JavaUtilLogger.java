package com.bubble.hearthstone.util.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaUtilLogger implements ILogger {

    private Logger logger;

    JavaUtilLogger() {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public void set(String name) {
        logger = Logger.getLogger(name);
    }

    public void log(LogLevel level, String message, Throwable thrown) {
        logger.log(parse(level), message, thrown);
    }

    public void log(LogLevel level, String message) {
        logger.log(parse(level), message);
    }
    
    public void log(String message) {
        log(LogLevel.IMPORTANT, message);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void warning(String message) {
        logger.warning(message);
    }

    private Level parse(LogLevel level) {
        switch(level) {
            default:
            case ALL:
                return Level.ALL;
            case IMPORTANT:
                return Level.SEVERE;
            case DEBUG:
                return Level.INFO;
            case WARNING:
                return Level.WARNING;
            case ERROR:
                return Level.SEVERE;
        }
    }
}