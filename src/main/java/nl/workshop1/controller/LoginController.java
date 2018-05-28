package nl.workshop1.controller;

import nl.workshop1.view.LoginMenu;
import nl.workshop1.service.LoginValidator;
import nl.workshop1.domain.Account;

/**
 *
 * @author FeniksBV
 */
public class LoginController implements MenuController {

    private LoginMenu loginMenu = new LoginMenu();
    private Account loginAccount;

    public void runMenu() {
        handleMenu();
    }

    @Override
    public void buildMenu() {
// Intentionally left empty
    }

    @Override
    public void handleMenu() {
        String userName;
        String wachtwoord;
        do {
            userName = loginMenu.userInputUserName();
            wachtwoord = loginMenu.userInputWachtwoord();
            
            if (userName.equals("") && wachtwoord.equals("")){
                AfsluitMenuController.applikaasieAfsluiten();
            }
            loginAccount = new Account( userName, wachtwoord);
        
        } while (!LoginValidator.validLoginAccount(loginAccount));
        
    }

    public Account getLoginAccount() {
        return loginAccount;
    }

    public char getLoginRole() {
        return loginAccount.getRole();
    }

    public String getLoginUserName() {
        return loginAccount.getUserName();
    }
}
