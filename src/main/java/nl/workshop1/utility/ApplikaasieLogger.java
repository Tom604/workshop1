/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.workshop1.utility;

import java.io.IOException;
import java.util.logging.*;

/**
 *
 * @author FeniksBV
 */
public class ApplikaasieLogger {

    private final static Logger logger = Logger.getLogger(ApplikaasieLogger.class.getName());
    private static FileHandler fh = null;

    public static void init() {
        try {
            LogManager.getLogManager().reset();
            // Second arg:
            // true means: append to existing file
            // false means: create new file
            fh = new FileHandler("applikaasie.log", false);
            fh.setLevel(Level.ALL);
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }

    }

    public static Logger getLogger() {
        return logger;
    }

}
