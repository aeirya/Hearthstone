package dev;

import ui.cli.color.Color;

/**
 * Log
 */
public class Log {
    
    Color color;
    String loggerName;
    String message;

    public Log(String message, Color color) {
        this.message = message;
        this.color = color;
    }

    public Log(String message, LogType type) {
        this(message, LogType.getColor(type));
    }

    public String toString() {
        return this.color.getAscii() + this.message;
    }
}