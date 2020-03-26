package dev;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * GameLogger
 */
public class GameLogger {

    private static Logger logger;
   
    private GameLogger() {}

    private static void setLogger(String loggerName) {
        logger = Logger.getLogger(loggerName);
    }

    private static void debugLog(String message) {
        logger.log(Level.ALL, message);
    }

    public static void debugLog(String message, String loggerName) {
        setLogger(loggerName);
        debugLog(message);
    }

    public static void debugLog(String message, Object ref) {
        debugLog(message, ref.getClass().getName());
    }
}