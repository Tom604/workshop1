/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.workshop1.controller;

import nl.workshop1.view.ProductMenu;

/**
 *
 * @author FeniksBV
 */
public class ProductMenuController implements MenuController {

    private ProductMenu productMenu = new ProductMenu();

    @Override
    public void buildMenu() {
        productMenu.addSubMenu("Nieuw product", "1");
        productMenu.addSubMenu("Zoek product " + "(filter)", "2");
        productMenu.addSubMenu("Wijzig product", "3");
        productMenu.addSubMenu("Verwijder product", "4");
    }

    @Override
    public void handleMenu() {
        while (true) {
            productMenu.drawMenu();
            switch (productMenu.userChoice()) {
                case "0":
                    return;
                case "1":
                    System.out.println("Nieuw product");
                    break;
                case "2":
                    System.out.println("Zoek product");
                    break;
                case "3":
                    System.out.println("Wijzig product");
                    break;
                case "4":
                    System.out.println("Verwijder product");
                    break;
            }
        }
    }

    public void runMenu() {
        productMenu.reset();
        buildMenu();
        handleMenu();
    }
}
