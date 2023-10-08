package service.driver;

import model.Driver;
import org.xml.sax.SAXException;
import service.driver.DriverServiceImpl;
import util.DBConnectionUtil;
import util.QueryUtil;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverServiceImpl implements IDriverService {


    public static final Logger log = Logger.getLogger(DriverServiceImpl.class.getName());

    private static Connection connection;
    private static Statement statement;
    private PreparedStatement preparedStatement;

    static {
        createDriverTable();
    }

    public DriverServiceImpl() {
    }

    public static void createDriverTable() {
//		try {
//			connection = DBConnectionUtil.getDBConnection();
//			statement = connection.createStatement();
//			
//			// drop table
//			//statement.executeUpdate(QueryUtil.queryByID("drop_table"));
//			
//			// create table
//			//statement.executeUpdate(QueryUtil.queryByID("create_driver_table"));
//			
//		} catch (SAXException | IOException | ParserConfigurationException | ClassNotFoundException | SQLException var1) {
//			log.log(Level.SEVERE, var1.getMessage());
//		}

    }

    @Override
    public void addDriver(Driver driver) {

        try {
            connection = DBConnectionUtil.getDBConnection();
            this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("insert_driver"));
            connection.setAutoCommit(false);

            String hashedPassword = generateMD5(driver.getPassword());

            this.preparedStatement.setString(1, driver.getName());
            this.preparedStatement.setString(2, driver.getEmail());
            this.preparedStatement.setString(3, hashedPassword);
            this.preparedStatement.setString(4, driver.getTel());


            this.preparedStatement.execute();
            connection.commit();
        } catch (SAXException | IOException | ParserConfigurationException | ClassNotFoundException |
                 SQLException var12) {
            log.log(Level.SEVERE, var12.getMessage());
        } finally {
            try {
                if (this.preparedStatement != null) {
                    this.preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException var11) {
                log.log(Level.SEVERE, var11.getMessage());
            }

        }

    }

    @Override
    public Driver getDriverByID(int id) {
        return (Driver) this.actionOnDriver(String.valueOf(id)).get(0);
    }

    @Override
    public Driver getDriverByEmail(String email) {
        Driver driver = new Driver();
        try {
            connection = DBConnectionUtil.getDBConnection();

            if (email != null && !email.isEmpty()) {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("driver_by_email"));
                this.preparedStatement.setString(1, email);
            }

            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                driver.setID(resultSet.getInt(1));
                driver.setName(resultSet.getString(2));
                driver.setEmail(resultSet.getString(3));
                driver.setPassword(resultSet.getString(4));
                driver.setTel(resultSet.getString(5));
            }

        } catch (SAXException | IOException | ParserConfigurationException | ClassNotFoundException |
                 SQLException var13) {
            log.log(Level.SEVERE, var13.getMessage());
        } finally {
            try {
                if (this.preparedStatement != null) {
                    this.preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException var12) {
                log.log(Level.SEVERE, var12.getMessage());
            }
        }
        return driver;
    }

    @Override
    public ArrayList<Driver> getDrivers() {
        return this.actionOnDriver((String) null);
    }

    @Override
    public Driver updateDriver(int id, Driver driver) {
        String driverID = String.valueOf(id);

        if (driverID != null && !driverID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("update_driver"));
                this.preparedStatement.setString(1, driver.getName());
                this.preparedStatement.setString(2, driver.getEmail());
                this.preparedStatement.setString(3, driver.getTel());
                this.preparedStatement.setInt(4, driver.getID());
                this.preparedStatement.executeUpdate();
            } catch (SAXException | IOException | ParserConfigurationException | ClassNotFoundException |
                     SQLException var12) {
                log.log(Level.SEVERE, var12.getMessage());
            } finally {
                try {
                    if (this.preparedStatement != null) {
                        this.preparedStatement.close();
                    }

                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException var11) {
                    log.log(Level.SEVERE, var11.getMessage());
                }

            }
        }

        return this.getDriverByID(Integer.parseInt(driverID));
    }

    @Override
    public void removeDriver(int id) {
        String driverID = String.valueOf(id);

        if (driverID != null && !driverID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("remove_driver"));
                this.preparedStatement.setString(1, driverID);
                this.preparedStatement.executeUpdate();
            } catch (SAXException | IOException | ParserConfigurationException | ClassNotFoundException |
                     SQLException var11) {
                log.log(Level.SEVERE, var11.getMessage());
            } finally {
                try {
                    if (this.preparedStatement != null) {
                        this.preparedStatement.close();
                    }

                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException var10) {
                    log.log(Level.SEVERE, var10.getMessage());
                }

            }
        }

    }

    private ArrayList<Driver> actionOnDriver(String driverID) {
        ArrayList<Driver> driverList = new ArrayList();

        try {
            connection = DBConnectionUtil.getDBConnection();

            if (driverID != null && !driverID.isEmpty()) {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("driver_by_id"));
                this.preparedStatement.setString(1, driverID);
            } else {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("all_drivers"));
            }

            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                Driver driver = new Driver();
                driver.setID(resultSet.getInt(1));
                driver.setName(resultSet.getString(2));
                driver.setEmail(resultSet.getString(3));
                driver.setPassword(resultSet.getString(4));
                driver.setTel(resultSet.getString(5));
                driverList.add(driver);
            }
        } catch (SAXException | IOException | ParserConfigurationException | ClassNotFoundException |
                 SQLException var13) {
            log.log(Level.SEVERE, var13.getMessage());
        } finally {
            try {
                if (this.preparedStatement != null) {
                    this.preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException var12) {
                log.log(Level.SEVERE, var12.getMessage());
            }

        }

        return driverList;
    }

    public String generateMD5(String password) {
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // Convert the bytes to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Return the complete hash
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
