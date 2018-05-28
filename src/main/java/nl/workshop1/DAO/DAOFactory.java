package nl.workshop1.DAO;

/**
 *
 * @author FeniksBV
 */
public class DAOFactory {

    private static AccountDAO accountDAO = new AccountDAOImpl();

    public static AccountDAO getAccountDAO() {
        return accountDAO;
    }
}
