package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil extends CommonUtil {
    private static Connection connection;

    private DBConnectionUtil() {
    }

    public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
    	
    	String url = "jdbc:mysql://localhost:3306/goflow";
        String username = "root";
        String password = "root";
    	
        if (connection == null || connection.isClosed()) {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }

        return connection;
    }
}
