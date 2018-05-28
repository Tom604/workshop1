package nl.workshop1.view;

import java.util.Scanner;

/**
 *
 * @author FeniksBV
 */
public class LoginMenu extends Menu {

    private static Scanner input = new Scanner(System.in);

    public LoginMenu() {
        super("Inloggen");
    }

    public String userInputUserName() {
        System.out.print("Gebruikersnaam : ");
        return input.nextLine();
    }

    public String userInputWachtwoord() {
        System.out.print("Wachtwoord     : ");
        return input.nextLine();
    }

}
