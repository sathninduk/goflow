package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil extends CommonUtil {
    private static Connection connection;

    private DBConnectionUtil() {
    }

    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
    	
    	String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
    	
        if (connection == null || connection.isClosed()) {
        	Class.forName(properties.getProperty("driverName"));
            connection = DriverManager.getConnection(url, username, password);
        }

        return connection;
    }
}
