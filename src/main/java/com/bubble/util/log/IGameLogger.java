package com.bubble.util.log;

public interface IGameLogger {
    public void log(String message, String from);
    public void error(String from);
    public void error(Object from, Throwable thrown);
    public void log(String... messages);
    public void logEvent(String message);
    public void warning(String message);
}