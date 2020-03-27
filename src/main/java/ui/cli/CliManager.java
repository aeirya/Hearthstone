package ui.cli;

import java.util.logging.Level;
import java.util.logging.Logger;
import ui.cli.color.*;

public class CliManager implements ui.IUiManager {

    public CliManager() {
        //idk what to put here :|
    }

    public void show() {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Heeey");
        String colorCode = ui.cli.color.ColorManager.getColorAscii(new Color(Colors.CYAN));
        dev.GameLogger.debugLog( colorCode+"Show CLI",new CliManager());
        dev.GameLogger.debugLog(
            ColorManager.ansiReset()+"This is a test"
        ,this);
        dev.GameLogger.debugLog("hallelujah", CliManager.class.getName()
        );
    }
}