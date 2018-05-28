
package nl.workshop1.utility;

import javax.sql.DataSource;

/**
 *
 * @author FeniksBV
 */
public class DbConnection {
    
    // Definieer de DataSource als public, dan heb je altijd een reference.
    public static DataSource dataSource = null;
    
    public static void initialize() {
         
        try {
            // Dit doe je eenmalig doen bij opstarten van je applikatie.
            DbConnectionPool jdbcObj = new DbConnectionPool();
            dataSource = jdbcObj.setUpPool();
//            jdbcObj.printDbStatus();
        } catch (Exception ex) {
            System.out.println("No ConnectionPool : " + ex.toString());
            System.exit(0);
        }
    }
}
