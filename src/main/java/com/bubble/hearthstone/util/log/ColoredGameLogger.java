package com.bubble.hearthstone.util.log;

public class ColoredGameLogger extends GameLogger {
    
    private AnsiColor color;

    public ColoredGameLogger() {
        color = AnsiColor.BLUE; //hardcoring the default value
    }

    @Override
    public void log(String message) {
        super.log(colored(message));
    }

    @Override
    public void warning(String message) {
        super.warning(AnsiColor.RED.apply(message));
    }

    @Override
    public void info(String message) {
        super.info(AnsiColor.GREEN.apply(message));
    }

    private String colored(String message) {
        return color.apply(message);
    }

    private enum AnsiColor {
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),    
        BLUE("\u001B[34m"),
        PURPLE("\u001B[35m");

        private static final String RESET = "\u001B[0m";
        private final String code;

        AnsiColor(String code) {
            this.code = code;
        }

        public String apply(String string) {
            return code + string + RESET;
        }
    }
}