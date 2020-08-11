package com.bubble.util.log;

/** connects system loggers to game logger */
interface ILogger {
    
    void set(String name);
    void log(String message);
    void log(LogLevel level, String message);
    void log(LogLevel level, String message, Throwable thrown);
    void info(String message);
    void warning(String message);
    
    enum LogLevel {
        DEBUG, ALL, IMPORTANT, WARNING, ERROR
    }
}