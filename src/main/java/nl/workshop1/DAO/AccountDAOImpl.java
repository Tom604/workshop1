package nl.workshop1.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import nl.workshop1.domain.Account;
import nl.workshop1.utility.ApplikaasieLogger;
import nl.workshop1.utility.DbConnection;

/**
 *
 * @author FeniksBV
 */
public class AccountDAOImpl implements AccountDAO {

    @Override
    public Account selectAccountByUserName(String userName) {

        ApplikaasieLogger.getLogger().log(Level.INFO, "Select Account for username={0}", userName);

        Account account = null;

        Connection connObj = null;
        PreparedStatement pstmtObj = null;
        ResultSet resultSet = null;
        try {
            // Performing Database Operation!
            // Making A New Connection Object For Db Transaction
            connObj = DbConnection.dataSource.getConnection();

            String query = "SELECT username, wachtwoord, account_type FROM account WHERE username = ?";
            pstmtObj = connObj.prepareStatement(query);
            pstmtObj.setString(1, userName);

            account = new Account();
            
            resultSet = pstmtObj.executeQuery();
            while (resultSet.next()) {
                account.setUserName(resultSet.getString(1));
                account.setWachtwoord(resultSet.getString(2));
                account.setRole(resultSet.getString(3).charAt(0));
            }

        } catch (Exception sqlException) {
            ApplikaasieLogger.getLogger().log(Level.WARNING, "SQL exception occurred ", sqlException);
        } finally {
            // Releasing Connection Object To Pool

            try {
                // Closing ResultSet Object
                if (resultSet != null) {
                    resultSet.close();
                }
                // Closing PreparedStatement Object
                if (pstmtObj != null) {
                    pstmtObj.close();
                }
                // Closing Connection Object
                if (connObj != null) {
                    connObj.close();
                }
            } catch (Exception sqlException) {
                ApplikaasieLogger.getLogger().log(Level.WARNING, "SQL exception occurred ", sqlException);
            }

        }
        return account;

    }
}
