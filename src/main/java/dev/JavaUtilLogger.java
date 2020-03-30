package dev;
import java.util.logging.Level;
import java.util.logging.Logger;

import ui.cli.color.Color;

/**
 * JavaUtilLogger
 */
public class JavaUtilLogger implements ILogger {
    private Logger logger;
   
    public JavaUtilLogger(Class<?> clazz) {
        setLogger(clazz);
    }

    private void setLogger(Class<?> clazz) {
        logger = Logger.getLogger(clazz.getClass().getName());
    }

    private void setLogger(String classname) {
        logger = Logger.getLogger(classname);
    }

    public void debug(String message) {
        logger.log(Level.SEVERE, message);
    }

    public void debug(String message, String loggerName) {
        setLogger(loggerName);
        debug(message);  
    }

    public void debug(String message, Object ref) {
        debug(message, ref.getClass().getName());
    }

    public void debug(String message, Object ref, Color color) {
        debug(color.getAscii() + message, ref );
    }

    public void info(String message) {
        logger.log(Level.INFO, message);
    }
}