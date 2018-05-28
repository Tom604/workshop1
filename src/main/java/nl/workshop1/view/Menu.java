package nl.workshop1.view;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author FeniksBV
 */
public abstract class Menu {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLUE = "\u001B[34m";

    private boolean autoAddZeroOption = true;
    private String menuHeader;
    private ArrayList<String> subMenu = null;
    private ArrayList<String> switchValue = null;

    public Menu() {
        this(null);
    }

    public Menu(String menuHeader) {
        this.menuHeader = menuHeader;
        subMenu = new ArrayList<>();
        switchValue = new ArrayList<>();
    }

    public void reset() {
        autoAddZeroOption = true;
        subMenu.clear();
        switchValue.clear();
    }
    public boolean enableAutoZeroOption() {
        autoAddZeroOption = true;
        return autoAddZeroOption;
    }

    public boolean disableAutoZeroOption() {
        autoAddZeroOption = false;
        return autoAddZeroOption;
    }

    public void addSubMenu(String subMenuName, String value) {
        subMenu.add(subMenuName);
        switchValue.add(value);
    }

    /**
     * Draw header and submenu-itens on the console. The option "0. terug" is
     * added depending on autoAddZeroOption
     *
     * @return : void
     */
    public void drawMenu() {
        
        System.out.println();
        if (menuHeader != null) {
            // header will be drawn in blue color
            System.out.println(ANSI_BLUE + menuHeader + ANSI_RESET);
        }

        for (int i = 0; i < subMenu.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + subMenu.get(i));
        }
        if (autoAddZeroOption) {
            System.out.println("  0. Terug");
        }
    }

    /**
     * Keeps asking the user for entering a key, until a valid key is pressed.
     *
     * @return : the selected key as a char
     */
    public String userChoice() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("Maak uw keuze : ");
            String choice = input.nextLine().toUpperCase();
            if (choice.length() == 1) {
                String value = validChoice(choice);
                if (value != null) {
                    return value;
                }
            }
        }
    }

    private String validChoice(String choice) {
        // Indien in de range A-Z
        if (choice.charAt(0) >= 'A' && choice.charAt(0) <= 'Z') {
// Dit moet nog worden geimplenteerd
            return null;
        }
        if (autoAddZeroOption) {
            if (choice.charAt(0) == '0') {
                return "0";
            }
        }

        // Indien in de range 1-9
        if (choice.charAt(0) >= '1' && choice.charAt(0) <= '9') {
            int index = Integer.valueOf(choice);
            // Is de gekozen optie aanwezig in het menu?
            if (index <= switchValue.size()) {
                return switchValue.get(index - 1);
            }
        }

        return null;
    }

}
