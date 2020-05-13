package com.bubble.hearthstone.util.log;

import java.util.Arrays;

/** least features every game logger should have  */
public class GameLogger extends AbstractLogger {

    public GameLogger() {
        this.logger = new JavaUtilLogger();
    }

    public GameLogger get(String name) {
        set(name);
        return this;
    }

    public void log(String message, String from) {
        log(from + ": " + message);
    }

    public void error(String from) {
        log("error!", from);
    }

    public void error(Object from, Throwable thrown) {
        log(LogLevel.ERROR, from.getClass().getName(), thrown);
    }

    public void log(String... messages) {
        log(concat(messages));
    }

    private String concat(String... strings) {
        final StringBuilder build = new StringBuilder();
        Arrays.asList(strings).forEach(build::append);
        return build.toString();
    }
}