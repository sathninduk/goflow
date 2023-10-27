package service.ride;

import model.*;
import model.Driver;
import org.xml.sax.SAXException;
import util.DBConnectionUtil;
import util.QueryUtil;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// ride service implementation
public class RideServiceImpl implements IRideService {

    // Java logger
    public static final Logger log = Logger.getLogger(RideServiceImpl.class.getName());

    private static Connection connection; // connection
    private static Statement statement; // statement
    private PreparedStatement preparedStatement; // prepared statement

    // static block
    static {
        //createRideTable();
    }

    // constructor
    public RideServiceImpl() {
    }

    // create ride table
    public static void createRideTable() {
		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();

			// drop table
			statement.executeUpdate(QueryUtil.queryByID("drop_table"));

			// create table
			statement.executeUpdate(QueryUtil.queryByID("create_ride_table"));

		} catch (SAXException | IOException | ParserConfigurationException | ClassNotFoundException | SQLException var1) {
			log.log(Level.SEVERE, var1.getMessage());
		}

    }

    // add ride
    @Override
    public int addRide(Ride ride) {

        // init id
        int addedId = 0;

        try {
            // create connection
            connection = DBConnectionUtil.getDBConnection();

            // create prepared statement
            this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("insert_ride"), Statement.RETURN_GENERATED_KEYS);

            connection.setAutoCommit(false); // set auto commit to false

            // set values
            this.preparedStatement.setFloat(1, ride.getStart_latitude());
            this.preparedStatement.setFloat(2, ride.getStart_longitude());
            this.preparedStatement.setFloat(3, ride.getEnd_latitude());
            this.preparedStatement.setFloat(4, ride.getEnd_longitude());
            this.preparedStatement.setInt(5, ride.getVehicleType().getVehicle_id());
            this.preparedStatement.setFloat(6, ride.getDistance());
            this.preparedStatement.setFloat(7, ride.getFare());
            this.preparedStatement.setInt(8, ride.getRider().getID());

            // execute query
            int affectedRows = this.preparedStatement.executeUpdate();

            // check if affected rows is 0
            if (affectedRows == 0) {
                throw new RuntimeException("Failed to insert record."); // throw exception
            }

            // get generated keys
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                addedId = generatedKeys.getInt(1); // get generated id
            } else {
                throw new RuntimeException("Failed to retrieve auto-generated ID."); // throw exception
            }

            // commit
            preparedStatement.close();
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

        return addedId; // return id
    }

    // get rides
    @Override
    public ArrayList<Ride> getRideByRider(Rider rider) {

        // init list
        ArrayList<Ride> rideList = new ArrayList<>();

        try {
            // create connection
            connection = DBConnectionUtil.getDBConnection();

            // create prepared statement
            this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("ride_by_rider"));

            // set values
            this.preparedStatement.setString(1, String.valueOf(rider.getID()));

            // execute query
            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {

                // init ride
                ActiveRide ride = new ActiveRide();

                // set values
                ride.setRideId(resultSet.getInt(1)); // ride id
                ride.setStart_latitude(resultSet.getFloat(2)); // start latitude
                ride.setStart_longitude(resultSet.getFloat(3)); // start longitude
                ride.setEnd_latitude(resultSet.getFloat(4)); // end latitude
                ride.setEnd_longitude(resultSet.getFloat(5)); // end longitude

                // vehicle type - object
                VehicleType vehicleType = new VehicleType();
                vehicleType.setName(resultSet.getString(6));
                ride.setVehicleType(vehicleType); // vehicle type

                ride.setDistance(resultSet.getFloat(7)); // distance
                ride.setFare(resultSet.getFloat(8)); // fare
                ride.setDate_time(resultSet.getDate(9)); // date_time

                // rider - object
                ride.setRider(rider); // rider

                // driver - object
                Driver driver = new Driver();
                driver.setID(resultSet.getInt(11));
                ride.setDriver(driver); // driver

                ride.setStatus(resultSet.getString(12)); // status

                rideList.add(ride); // add to list
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

        return rideList; // return list
    }

    // get rides by status and vehicle type
    @Override
    public ArrayList<Ride> getRidesByStatusAndVehicle(String status, VehicleType vehicleTypeIn) {

        // init list
        ArrayList<Ride> rideList = new ArrayList<Ride>();

        try {
            connection = DBConnectionUtil.getDBConnection(); // create connection

            // create prepared statement
            this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("ride_by_status"));
            this.preparedStatement.setString(1, status);
            this.preparedStatement.setInt(2, vehicleTypeIn.getVehicle_id());

            // execute query
            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                // init ride
                ActiveRide ride = new ActiveRide();

                // set values
                ride.setRideId(resultSet.getInt(1)); // ride id
                ride.setStart_latitude(resultSet.getFloat(2)); // start latitude
                ride.setStart_longitude(resultSet.getFloat(3)); // start longitude
                ride.setEnd_latitude(resultSet.getFloat(4)); // end latitude
                ride.setEnd_longitude(resultSet.getFloat(5)); // end longitude

                // vehicle type - object
                VehicleType vehicleType = new VehicleType();
                vehicleType.setName(resultSet.getString(6));
                ride.setVehicleType(vehicleType); // vehicle type

                ride.setDistance(resultSet.getFloat(7)); // distance
                ride.setFare(resultSet.getFloat(8)); // fare
                ride.setDate_time(resultSet.getDate(9)); // date_time

                // rider - object
                Rider rider = new Rider();
                rider.setID(resultSet.getInt(10));
                ride.setRider(rider); // rider

                // driver - object
                Driver driver = new Driver();
                driver.setID(resultSet.getInt(11));
                ride.setDriver(driver); // driver

                ride.setStatus(resultSet.getString(12)); // status

                // add to list
                rideList.add(ride);
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

        return rideList; // return list
    }

    // get ride by id
    @Override
    public Ride getRideByID(int id) {
        return this.actionOnRide(String.valueOf(id)).get(0); // return ride
    }

    // check if ride exists
    @Override
    public boolean checkRideExists(int id) {
        return !this.actionOnRide(String.valueOf(id)).isEmpty(); // return true if ride exists
    }


    // update ride status
    @Override
    public void updateRideStatus(int id, String status, Driver driver) {

        // init ride id
        String rideID = String.valueOf(id);

        if (rideID != null && !rideID.isEmpty()) { // check if ride id is not null or empty
            try {
                // create connection
                connection = DBConnectionUtil.getDBConnection();

                // create prepared statement
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("update_ride_status"));

                // set values
                this.preparedStatement.setString(1, status);
                this.preparedStatement.setInt(2, driver.getID());
                this.preparedStatement.setInt(3, id);

                this.preparedStatement.executeUpdate(); // execute query

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

    }

    // remove ride
    @Override
    public void removeRide(int id) {

        // init ride id
        String rideID = String.valueOf(id);

        if (rideID != null && !rideID.isEmpty()) { // check if ride id is not null or empty
            try {

                // create connection
                connection = DBConnectionUtil.getDBConnection();

                // create prepared statement
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("delete_ride"));

                // set values
                this.preparedStatement.setString(1, rideID);

                // execute query
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

    // action on ride
    private ArrayList<Ride> actionOnRide(String rideID) {

        // init list
        ArrayList<Ride> rideList = new ArrayList();

        // check if ride id is not null or empty
        try {
            connection = DBConnectionUtil.getDBConnection(); // create connection

            // check if ride id is not null or empty
            if (rideID != null && !rideID.isEmpty()) {
                // create prepared statement
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("ride_by_id"));
                this.preparedStatement.setString(1, String.valueOf(Integer.parseInt(rideID)));
            } else { // else
                // create prepared statement
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("all_rides"));
            }

            // execute query
            ResultSet resultSet = this.preparedStatement.executeQuery();

            // iterate through result set
            while (resultSet.next()) {

                ActiveRide ride = new ActiveRide(); // init ride

                ride.setRideId(resultSet.getInt(1)); // ride id
                ride.setStart_latitude(resultSet.getFloat(2)); // start latitude
                ride.setStart_longitude(resultSet.getFloat(3)); // start longitude
                ride.setEnd_latitude(resultSet.getFloat(4)); // end latitude
                ride.setEnd_longitude(resultSet.getFloat(5)); // end longitude

                // vehicle type - object
                VehicleType vehicleType = new VehicleType();
                vehicleType.setName(resultSet.getString(6));
                ride.setVehicleType(vehicleType); // vehicle type

                ride.setDistance(resultSet.getFloat(7)); // distance
                ride.setFare(resultSet.getFloat(8)); // fare
                ride.setDate_time(resultSet.getDate(9)); // date_time

                // rider - object
                Rider rider = new Rider();
                rider.setID(resultSet.getInt(10));
                ride.setRider(rider); // rider

                // driver - object
                Driver driver = new Driver();
                driver.setID(resultSet.getInt(11));
                ride.setDriver(driver); // driver

                ride.setStatus(resultSet.getString(12)); // status

                rideList.add(ride);
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

        return rideList; // return list
    }

}
