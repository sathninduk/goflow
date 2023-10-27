package service.driver;

import model.Driver;
import org.xml.sax.SAXException;
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

// This is the implementation of the DriverService class
public class DriverServiceImpl implements IDriverService {

    // logger object
    public static final Logger log = Logger.getLogger(DriverServiceImpl.class.getName());

    private static Connection connection; // connection object
    private static Statement statement; // statement object
    private PreparedStatement preparedStatement; // prepared statement object

    static { // static block
        //createDriverTable();
    }

    public DriverServiceImpl() { // default constructor
    }

    // This method is used to create the driver table
    public static void createDriverTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();

			// drop table
			statement.executeUpdate(QueryUtil.queryByID("drop_table"));

			// create table
			statement.executeUpdate(QueryUtil.queryByID("create_driver_table"));

		} catch (SAXException | IOException | ParserConfigurationException | ClassNotFoundException | SQLException var1) {
			log.log(Level.SEVERE, var1.getMessage());
		}

    }

    // This method is used to add a driver
    @Override
    public void addDriver(Driver driver) {

        try {
            connection = DBConnectionUtil.getDBConnection();
            this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("insert_driver"));
            connection.setAutoCommit(false);

            String hashedPassword = generateMD5(driver.getPassword());

            this.preparedStatement.setString(1, driver.getName());
            this.preparedStatement.setString(2, driver.getEmail());
            this.preparedStatement.setInt(3, driver.getVehicleType());
            this.preparedStatement.setString(4, hashedPassword);
            this.preparedStatement.setString(5, driver.getTel());


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

    // This method is used to get drivers by vehicle type
    @Override
    public ArrayList<Driver> getDriversByVehicleType(int vehicleTypeId) {
        ArrayList<Driver> driverList = new ArrayList();

        try {
            connection = DBConnectionUtil.getDBConnection();
            this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("driver_by_vehicle_type"));
            this.preparedStatement.setInt(1, vehicleTypeId);
            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                Driver driver = new Driver();
                driver.setID(resultSet.getInt(1));
                driver.setName(resultSet.getString(2));
                driver.setEmail(resultSet.getString(3));
                driver.setVehicleType(resultSet.getInt(4));
                driver.setPassword(resultSet.getString(5));
                driver.setTel(resultSet.getString(6));
                driverList.add(driver);
            }
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

        return driverList;
    }

    // This method is used to get a driver by id
    @Override
    public Driver getDriverByID(int id) {
            return (Driver) this.actionOnDriver(String.valueOf(id)).get(0);
    }

    // This method is used to get a driver by email
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
                driver.setVehicleType(Integer.parseInt(resultSet.getString(4)));
                driver.setPassword(resultSet.getString(5));
                driver.setTel(resultSet.getString(6));
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

    // This method is used to get all drivers
    @Override
    public ArrayList<Driver> getDrivers() {
        return this.actionOnDriver((String) null);
    }

    // This method is used to update a driver
    @Override
    public Driver updateDriver(int id, Driver driver) {
        String driverID = String.valueOf(id);

        if (driverID != null && !driverID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("update_driver"));
                this.preparedStatement.setString(1, driver.getName());
                this.preparedStatement.setString(2, driver.getEmail());
                this.preparedStatement.setInt(3, driver.getVehicleType());
                this.preparedStatement.setString(4, driver.getTel());
                this.preparedStatement.setInt(5, driver.getID());
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

    // This method is used to remove a driver
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

    // This method is used to perform actions on the driver
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
                driver.setVehicleType(resultSet.getInt(4));
                driver.setPassword(resultSet.getString(5));
                driver.setTel(resultSet.getString(6));
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

    // This method is used to generate the MD5 hash
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
