package nl.workshop1.controller;

import nl.workshop1.domain.*;
import nl.workshop1.view.HoofdMenu;

/**
 *
 * @author FeniksBV
 */
public class HoofdMenuController implements MenuController {

    private HoofdMenu hoofdmenu = new HoofdMenu();
    private Account login;

    public HoofdMenuController( Account login ) {
        this.login = login;
    }

    @Override
    public void buildMenu() {

        hoofdmenu.addSubMenu("Bestellingen", "1");
        if (login.getRole() == Account.ROLE_ADMIN || login.getRole() == Account.ROLE_MEDEWERKER) {
            hoofdmenu.addSubMenu("Klanten", "2");
        }
        if (login.getRole() == Account.ROLE_ADMIN || login.getRole() == Account.ROLE_MEDEWERKER) {
            hoofdmenu.addSubMenu("Producten", "3");
        }
        if (login.getRole() == Account.ROLE_ADMIN) {
            hoofdmenu.addSubMenu("Accounts", "4");
        }
    }

    @Override
    public void handleMenu() {
        while (true) {
            hoofdmenu.drawMenu();
            switch (hoofdmenu.userChoice()) {
                case "0":
                    AfsluitMenuController afsluit = new AfsluitMenuController();
                    afsluit.runMenu();
                    break;
                case "1":
                    System.out.println("Bestellingen");
                    break;
                case "2":
                    System.out.println("Klanten");
                    break;
                case "3":
                    ProductMenuController product = new ProductMenuController();
                    product.runMenu();
                    break;
                case "4":
                    System.out.println("Accounts");
                    break;
            }
        }
    }

    public void runMenu() {
        hoofdmenu.reset();
        buildMenu();
        handleMenu();
    }
}
