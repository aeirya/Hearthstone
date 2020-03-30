package dev;

import org.slf4j.*;
/**
 * GameLogger
 */
public class Slf4jLogger implements ILogger {
    Logger logger;

    public Slf4jLogger(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz.getName());
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void debug(Log log) {
        debug(log.toString());
    }

    public void info(String message) {
        logger.info(message);
    }
}