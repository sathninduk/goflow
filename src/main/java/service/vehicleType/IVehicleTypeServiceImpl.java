package service.vehicleType;

import java.util.ArrayList;
import java.util.logging.Logger;

import model.Rider;
import model.VehicleType;
import util.DBConnectionUtil;
import util.QueryUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

// This is the implementation of the VehicleTypeService class
public class IVehicleTypeServiceImpl implements IVehicleTypeService {

    // logger object
    public static final Logger log = Logger.getLogger(service.vehicleType.IVehicleTypeServiceImpl.class.getName());

    private static Connection connection; // connection object
    private static Statement statement; // statement object
    private PreparedStatement preparedStatement; // prepared statement object

    static { // static block
        //createVehicleTypeTable();
    }

    public IVehicleTypeServiceImpl() {
    }

    public static void createVehicleTypeTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();

			// drop table
			statement.executeUpdate(QueryUtil.queryByID("drop_table"));

			// create table
			statement.executeUpdate(QueryUtil.queryByID("create_vehicleType_table"));

		} catch (SAXException | IOException | ParserConfigurationException | ClassNotFoundException | SQLException var1) {
			log.log(Level.SEVERE, var1.getMessage());
		}

    }

    // This method is used to add a vehicle type
    @Override
    public void addVehicleType(VehicleType vehicleType) {

        try {
            connection = DBConnectionUtil.getDBConnection();
            this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("insert_vehicleType"));
            connection.setAutoCommit(false);

            this.preparedStatement.setString(1, vehicleType.getName());
            this.preparedStatement.setFloat(2, vehicleType.getRate());


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

    // This method is used to get a vehicle type by id
    @Override
    public VehicleType getVehicleTypeByID(int id) {
        return (VehicleType) this.actionOnVehicleType(String.valueOf(id)).get(0);
    }

    // This method is used to get a vehicle type by name
    @Override
    public VehicleType getVehicleTypeByName(String name) {

        VehicleType vehicleType = new VehicleType();

        try {
            connection = DBConnectionUtil.getDBConnection();
            this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("vehicleType_by_name"));
            this.preparedStatement.setString(1, name);

            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                vehicleType.setVehicle_id(resultSet.getInt(1));
                vehicleType.setName(resultSet.getString(2));
                vehicleType.setRate(resultSet.getFloat(3));
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

        return vehicleType;
    }

    // This method is used to get all vehicle types
    @Override
    public ArrayList<VehicleType> getVehicleTypes() {
        return this.actionOnVehicleType((String) null);
    }

    // This method is used to update a vehicle type
    @Override
    public VehicleType updateVehicleType(int id, VehicleType vehicleType) {
        String vehicleTypeID = String.valueOf(id);

        if (vehicleTypeID != null && !vehicleTypeID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("update_vehicleType"));

                this.preparedStatement.setString(1, vehicleType.getName());
                this.preparedStatement.setFloat(2, vehicleType.getRate());

                this.preparedStatement.setInt(3, vehicleType.getVehicle_id());
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

        return this.getVehicleTypeByID(Integer.parseInt(vehicleTypeID));
    }

    // This method is used to remove a vehicle type
    @Override
    public void removeVehicleType(int id) {
        String vehicleTypeID = String.valueOf(id);

        if (vehicleTypeID != null && !vehicleTypeID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("remove_vehicleType"));
                this.preparedStatement.setString(1, vehicleTypeID);
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

    // This method is used to perform the action on the vehicle type
    private ArrayList<VehicleType> actionOnVehicleType(String vehicleTypeID) {
        ArrayList<VehicleType> vehicleTypeList = new ArrayList<VehicleType>();

        try {
            connection = DBConnectionUtil.getDBConnection();

            if (vehicleTypeID != null && !vehicleTypeID.isEmpty()) {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("vehicleType_by_id"));
                this.preparedStatement.setString(1, vehicleTypeID);
            } else {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("all_vehicleTypes"));
            }

            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                VehicleType vehicleType = new VehicleType();

                vehicleType.setVehicle_id(resultSet.getInt(1));
                vehicleType.setName(resultSet.getString(2));
                vehicleType.setRate(resultSet.getFloat(3));

                vehicleTypeList.add(vehicleType);
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

        return vehicleTypeList;
    }


}