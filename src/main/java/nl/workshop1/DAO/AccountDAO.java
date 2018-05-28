/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.workshop1.DAO;

import nl.workshop1.domain.Account;

/**
 *
 * @author FeniksBV
 */
public interface AccountDAO {
    
    public Account selectAccountByUserName( String userName);
}
