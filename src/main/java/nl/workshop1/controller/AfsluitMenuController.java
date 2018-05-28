/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.workshop1.controller;

import java.util.logging.Handler;
import java.util.logging.Level;
import nl.workshop1.utility.ApplikaasieLogger;
import nl.workshop1.view.AfsluitMenu;

/**
 *
 * @author FeniksBV
 */
public class AfsluitMenuController implements MenuController {

    private AfsluitMenu afsluitMenu = new AfsluitMenu();

    @Override
    public void buildMenu() {
        afsluitMenu.disableAutoZeroOption();
        afsluitMenu.addSubMenu("Afsluiten", "1");
        afsluitMenu.addSubMenu("Doorgaan", "2");
    }

    @Override
    public void handleMenu() {
        while (true) {
            afsluitMenu.drawMenu();
            switch (afsluitMenu.userChoice()) {
                case "1":
                    applikaasieAfsluiten();
                    break;

                case "2":
                    return;
            }
        }
    }

    public void runMenu() {
        afsluitMenu.reset();
        buildMenu();
        handleMenu();
    }

    public static void applikaasieAfsluiten() {
        ApplikaasieLogger.getLogger().log(Level.INFO, "Applikaasie ended");
        System.out.println("\n\nThanks for using Applikaasie. See you soon!");

        for (Handler h : ApplikaasieLogger.getLogger().getHandlers()) {
            h.close();
        }
        
        System.exit(0);
    }
}
