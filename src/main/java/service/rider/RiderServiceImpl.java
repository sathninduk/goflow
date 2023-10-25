package service.rider;

import java.util.ArrayList;
import java.util.logging.Logger;

import model.Rider;
import util.DBConnectionUtil;
import util.QueryUtil;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class RiderServiceImpl implements IRiderService {

    public static final Logger log = Logger.getLogger(RiderServiceImpl.class.getName());

    private static Connection connection;
    private static Statement statement;
    private PreparedStatement preparedStatement;

    public RiderServiceImpl() {
    }


    @Override
    public void addRider(Rider rider) {

        try {
            connection = DBConnectionUtil.getDBConnection();
            this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("insert_rider"));
            connection.setAutoCommit(false);

            String hashedPassword = generateMD5(rider.getPassword());

            this.preparedStatement.setString(1, rider.getName());
            this.preparedStatement.setString(2, rider.getEmail());
            this.preparedStatement.setString(3, hashedPassword);
            this.preparedStatement.setString(4, rider.getTel());


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
    public Rider getRiderByID(int id) {
        return (Rider) this.actionOnRider(String.valueOf(id)).get(0);
    }

    @Override
    public Rider getRiderByEmail(String email) {
        Rider rider = new Rider();
        try {
            connection = DBConnectionUtil.getDBConnection();

            if (email != null && !email.isEmpty()) {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("rider_by_email"));
                this.preparedStatement.setString(1, email);
            }

            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                rider.setID(resultSet.getInt(1));
                rider.setName(resultSet.getString(2));
                rider.setEmail(resultSet.getString(3));
                rider.setPassword(resultSet.getString(4));
                rider.setTel(resultSet.getString(5));
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
        return rider;
    }

    @Override
    public ArrayList<Rider> getRiders() {
        return this.actionOnRider((String) null);
    }

    @Override
    public Rider updateRider(int id, Rider rider) {
        String riderID = String.valueOf(id);

        if (riderID != null && !riderID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("update_rider"));
                this.preparedStatement.setString(1, rider.getName());
                this.preparedStatement.setString(2, rider.getEmail());
                this.preparedStatement.setString(3, rider.getTel());
                this.preparedStatement.setInt(4, rider.getID());
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

        return this.getRiderByID(Integer.parseInt(riderID));
    }

    @Override
    public void removeRider(int id) {
        String riderID = String.valueOf(id);

        if (riderID != null && !riderID.isEmpty()) {
            try {
                connection = DBConnectionUtil.getDBConnection();
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("remove_rider"));
                this.preparedStatement.setString(1, riderID);
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

    private ArrayList<Rider> actionOnRider(String riderID) {
        ArrayList<Rider> riderList = new ArrayList<Rider>();

        try {
            connection = DBConnectionUtil.getDBConnection();

            if (riderID != null && !riderID.isEmpty()) {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("rider_by_id"));
                this.preparedStatement.setString(1, riderID);
            } else {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("all_riders"));
            }

            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                Rider rider = new Rider();
                rider.setID(resultSet.getInt(1));
                rider.setName(resultSet.getString(2));
                rider.setEmail(resultSet.getString(3));
                rider.setPassword(resultSet.getString(4));
                rider.setTel(resultSet.getString(5));
                riderList.add(rider);
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

        return riderList;
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
