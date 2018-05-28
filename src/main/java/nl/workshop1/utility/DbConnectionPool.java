package nl.workshop1.utility;

import java.io.*;
import java.util.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp.ConnectionFactory;
import org.apache.commons.dbcp.DriverManagerConnectionFactory;
import org.apache.commons.dbcp.PoolableConnectionFactory;
import org.apache.commons.dbcp.PoolingDataSource;
import org.apache.commons.pool.impl.GenericObjectPool;

/**
 *
 * @author FeniksBV
 */
public class DbConnectionPool {

    private static GenericObjectPool gPool = null;

    public DataSource setUpPool() throws Exception {

        // Initialize a file which holds all DB properties
        // JDBC Driver Name & Database URL
        // JDBC Database Credentials (user / password) 
        Properties props = new Properties();
        FileInputStream in = new FileInputStream("db.properties");
        props.load(in);
        in.close();

        String driver = props.getProperty("jdbc.driver");
        Class.forName(driver);

        // Creates an Instance of GenericObjectPool That Holds Our Pool of (max 5) Connections Object!
        gPool = new GenericObjectPool();
        gPool.setMaxActive(5);

        // Creates a ConnectionFactory Object Which Will Be Use by the Pool to Create the Connection Object!
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        ConnectionFactory cf = new DriverManagerConnectionFactory(url, username, password);

        // Creates a PoolableConnectionFactory That Will Wraps the Connection Object Created by the ConnectionFactory to Add Object Pooling Functionality!
        PoolableConnectionFactory pcf = new PoolableConnectionFactory(cf, gPool, null, null, false, true);
        return new PoolingDataSource(gPool);
    }

    public GenericObjectPool getConnectionPool() {
        return gPool;
    }

    // This Method Is Used To Print The Connection Pool Status
    public void printDbStatus() {
        System.out.println("DbStatus->Max.: " + getConnectionPool().getMaxActive() + "; Active: " + getConnectionPool().getNumActive() + "; Idle: " + getConnectionPool().getNumIdle());
        System.out.println();
    }
}
