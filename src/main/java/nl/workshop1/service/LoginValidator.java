/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.workshop1.service;

import nl.workshop1.domain.Account;
import nl.workshop1.DAO.DAOFactory;

/**
 *
 * @author FeniksBV
 */
public class LoginValidator {
    
    public static boolean validLoginAccount( Account loginAccount){

        Account Account = DAOFactory.getAccountDAO().selectAccountByUserName(loginAccount.getUserName());
        
        if (Account != null) {
            if (Account.getWachtwoord() != null) {
                if (loginAccount.getWachtwoord().equals(Account.getWachtwoord())) {
                    loginAccount.setRole( Account.getRole());
                    return true;
                }
            }
        }
        return false;
    }
}
