package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// This class is used to get the database connection
public class DBConnectionUtil extends CommonUtil {
    private static Connection connection; // connection object

    private DBConnectionUtil() { // end constructor
    }

    // This method is used to get the database connection
    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {

        // This will read the database properties file
    	String url = properties.getProperty("url"); // get the url from the properties file
        String username = properties.getProperty("username"); // get the username from the properties file
        String password = properties.getProperty("password"); // get the password from the properties file

        // This will check if the connection is null or closed
        if (connection == null || connection.isClosed()) {
        	Class.forName(properties.getProperty("driverName")); // get the driver name from the properties file
            connection = DriverManager.getConnection(url, username, password); // get the connection
        }

        return connection; // return the connection
    }
}
