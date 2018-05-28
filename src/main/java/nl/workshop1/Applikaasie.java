/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.workshop1;

import java.util.logging.Level;
import nl.workshop1.controller.*;
import nl.workshop1.utility.ApplikaasieLogger;
import nl.workshop1.utility.DbConnection;
import nl.workshop1.utility.DbConnectionPool;

/**
 *
 * @author FeniksBV
 */
public class Applikaasie {
// Waar o waar ?
    public static void main(String[] args) {
        // Logger
        ApplikaasieLogger.init();
        ApplikaasieLogger.getLogger().log(Level.INFO, "Applikaasie started");

        // Database
        DbConnection.initialize();
        
        System.out.println("\nHello!! Welcome at workshop1 -> the cheese factory.");
       
        // Ask user for login.
        LoginController login = new LoginController();
        login.runMenu();

        HoofdMenuController hoofdmenu = new HoofdMenuController( login.getLoginAccount());
        hoofdmenu.runMenu();

    }
}
