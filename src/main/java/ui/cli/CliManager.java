package ui.cli;
//logging 
import java.util.logging.Level;
import java.util.logging.Logger;

public class CliManager implements ui.IUiManager {
    private Logger logger;
    
    public CliManager() {
        logger = Logger.getLogger(CliManager.class.getName());
    }

    public void show() {
        logger.log(Level.INFO , "Started CLI Manager");
    }
}