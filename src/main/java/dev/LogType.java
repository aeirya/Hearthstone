package dev;

import ui.cli.color.Color;
import ui.cli.color.Colors;

enum LogType {
    DEBUG;
    public static Color getColor(LogType type) {
        if (type==LogType.DEBUG) return new Color(Colors.GREEN);
        else return new Color(Colors.WHITE);
    }
}