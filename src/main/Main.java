package src.main;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class Main {

    public static final Logger logger = System.getLogger(Main.class.getName());
    public static void main(String[] args) {
        
        logger.log(Level.INFO, "Application started!");
        
    }
}