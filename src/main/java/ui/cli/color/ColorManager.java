package ui.cli.color;

/**
 * ColorManager
 */
public class ColorManager {

    private ColorManager() { }

    private static String generate(int n) {
        return "\u001B["+ n + "m";
    }

    public static String getColorAscii(Color color) {
        int n = 30; //color number, representing black first 
        n += color.name.ordinal();
        if (color.isBright) {
            n += 60;
        }
        if (color.isForeground) {
            n += 10;
        }
        return generate(n);
    }
    
    public static String ansiReset() {
        return generate(0);
    }
}