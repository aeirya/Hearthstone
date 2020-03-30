package dev;
import java.util.logging.Level;
import java.util.logging.Logger;

import ui.cli.color.Color;

/**
 * JavaUtilGameLogger
 */
public class JavaUtilLogger {
    private static Logger logger;
   
    private JavaUtilLogger() {}

    public static void setLogger(String loggerName) {
        logger = Logger.getLogger(loggerName);
    }

    public static void debugLog(String message) {
        logger.log(Level.SEVERE, message);
    }

    public static void debugLog(String message, String loggerName) {
        setLogger(loggerName);
        debugLog(message);  
    }

    public static void debugLog(String message, Object ref) {
        debugLog(message, ref.getClass().getName());
    }

    public static void debugLog(String message, Object ref, Color color) {
        debugLog(color.getAscii() + message, ref );
    }
}