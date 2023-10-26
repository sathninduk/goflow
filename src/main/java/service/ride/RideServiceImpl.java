package service.ride;

import model.*;
import model.Driver;
import model.Factory.RideFactory;
import org.xml.sax.SAXException;
import util.DBConnectionUtil;
import util.QueryUtil;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RideServiceImpl implements IRideService {


    public static final Logger log = Logger.getLogger(RideServiceImpl.class.getName());

    private static Connection connection;
    private static Statement statement;
    private PreparedStatement preparedStatement;

    static {
        createRideTable();
    }

    public RideServiceImpl() {
    }

    public static void createRideTable() {
//		try {
//			connection = DBConnectionUtil.getDBConnection();
//			statement = connection.createStatement();
//
//			// drop table
//			//statement.executeUpdate(QueryUtil.queryByID("drop_table"));
//
//			// create table
//			//statement.executeUpdate(QueryUtil.queryByID("create_ride_table"));
//
//		} catch (SAXException | IOException | ParserConfigurationException | ClassNotFoundException | SQLException var1) {
//			log.log(Level.SEVERE, var1.getMessage());
//		}

    }

    @Override
    public int addRide(Ride ride) {

        int addedId = 0;

        try {
            connection = DBConnectionUtil.getDBConnection();
            this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("insert_ride"), Statement.RETURN_GENERATED_KEYS);
            connection.setAutoCommit(false);

//            this.preparedStatement.setInt(1, ride.getRideId());
            this.preparedStatement.setFloat(1, ride.getStart_latitude());
            this.preparedStatement.setFloat(2, ride.getStart_longitude());
            this.preparedStatement.setFloat(3, ride.getEnd_latitude());
            this.preparedStatement.setFloat(4, ride.getEnd_longitude());
            this.preparedStatement.setInt(5, ride.getVehicleType().getVehicle_id());
            this.preparedStatement.setFloat(6, ride.getDistance());
            this.preparedStatement.setFloat(7, ride.getFare());
//            this.preparedStatement.setDate(8, (Date) ride.getDate_time());
            this.preparedStatement.setInt(8, ride.getRider().getID());
//            this.preparedStatement.setInt(10, ride.getDriver().getID());
//            this.preparedStatement.setString(11, ride.getStatus());

            int affectedRows = this.preparedStatement.executeUpdate();


            if (affectedRows == 0) {
                throw new RuntimeException("Failed to insert record.");
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                addedId = generatedKeys.getInt(1);
            } else {
                throw new RuntimeException("Failed to retrieve auto-generated ID.");
            }

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

        return addedId;
    }

    @Override
    public ArrayList<Ride> getRideByRider(Rider rider) {
        ArrayList<Ride> rideList = new ArrayList<>();

        try {
            connection = DBConnectionUtil.getDBConnection();

            this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("ride_by_rider"));
            this.preparedStatement.setString(1, String.valueOf(rider.getID()));


            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                ActiveRide ride = new ActiveRide();

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

        return rideList;
    }

    @Override
    public ArrayList<Ride> getRidesByStatusAndVehicle(String status, VehicleType vehicleTypeIn) {
        ArrayList<Ride> rideList = new ArrayList<Ride>();

        try {
            connection = DBConnectionUtil.getDBConnection();

            this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("ride_by_status"));
            this.preparedStatement.setString(1, status);
            this.preparedStatement.setInt(2, vehicleTypeIn.getVehicle_id());

            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                ActiveRide ride = new ActiveRide();

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

        return rideList;
    }

    @Override
    public Ride getRideByID(int id) {
        return this.actionOnRide(String.valueOf(id)).get(0);
    }

    @Override
    public boolean checkRideExists(int id) {
        return !this.actionOnRide(String.valueOf(id)).isEmpty();
    }

    @Override
    public ArrayList<Ride> getRides() {
        return this.actionOnRide((String) null);
    }

//    @Override
//    public Ride updateRide(int id, Ride ride) {
//        String rideID = String.valueOf(id);
//
//        if (rideID != null && !rideID.isEmpty()) {
//            try {
//                connection = DBConnectionUtil.getDBConnection();
//                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("update_ride"));
//
//                this.preparedStatement.setInt(1, ride.getRideId());
//                this.preparedStatement.setFloat(1, ride.getStart_latitude());
//                this.preparedStatement.setFloat(2, ride.getStart_longitude());
//                this.preparedStatement.setFloat(3, ride.getEnd_latitude());
//                this.preparedStatement.setFloat(4, ride.getEnd_longitude());
//                this.preparedStatement.setString(5, ride.getVehicleType().getName());
//                this.preparedStatement.setFloat(6, ride.getDistance());
//                this.preparedStatement.setFloat(7, ride.getFare());
//                this.preparedStatement.setDate(8, (Date) ride.getDate_time());
//                this.preparedStatement.setInt(9, ride.getRider().getID());
//                this.preparedStatement.setInt(10, ride.getDriver().getID());
//                this.preparedStatement.setString(11, ride.getStatus());
//
//                this.preparedStatement.executeUpdate();
//            } catch (SAXException | IOException | ParserConfigurationException | ClassNotFoundException |
//                     SQLException var12) {
//                log.log(Level.SEVERE, var12.getMessage());
//            } finally {
//                try {
//                    if (this.preparedStatement != null) {
//                        this.preparedStatement.close();
//                    }
//
//                    if (connection != null) {
//                        connection.close();
//                    }
//                } catch (SQLException var11) {
//                    log.log(Level.SEVERE, var11.getMessage());
//                }
//
//            }
//        }
//
//        return this.getRideByID(Integer.parseInt(rideID));
//    }


    @Override
    public void updateRideStatus(int id, String status, Driver driver) {
        String rideID = String.valueOf(id);

        if (rideID != null && !rideID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("update_ride_status"));

                this.preparedStatement.setString(1, status);
                this.preparedStatement.setInt(2, driver.getID());
                this.preparedStatement.setInt(3, id);

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

        //return this.getRideByID(Integer.parseInt(rideID));
    }

    @Override
    public void removeRide(int id) {
        String rideID = String.valueOf(id);

        if (rideID != null && !rideID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("delete_ride"));
                this.preparedStatement.setString(1, rideID);
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

    private ArrayList<Ride> actionOnRide(String rideID) {
        ArrayList<Ride> rideList = new ArrayList();

        try {
            connection = DBConnectionUtil.getDBConnection();

            if (rideID != null && !rideID.isEmpty()) {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("ride_by_id"));
                this.preparedStatement.setString(1, String.valueOf(Integer.parseInt(rideID)));
            } else {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("all_rides"));
            }


            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                ActiveRide ride = new ActiveRide();

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

        return rideList;
    }

}
