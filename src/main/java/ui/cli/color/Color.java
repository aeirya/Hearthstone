package ui.cli.color;

/**
 * Color class,
 * boolean parameters default at false
 */
public class Color {
    Colors name;
    boolean isBright;
    boolean isForeground;

    public Color(Colors colorName, boolean isForeground, boolean isBright) {
        this.name = colorName;
        this.isBright = isBright;
        this.isForeground = isForeground;
    }

    public Color(Colors colorName, boolean isForeground) {
        this(colorName, isForeground, false);
    }

    public Color(Colors colorName) {
        this(colorName, false, false);
    }

    public Color() {
        this(Colors.BLACK, false, false);
    }
}