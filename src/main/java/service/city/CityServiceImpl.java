package service.city;

import model.City;
import org.xml.sax.SAXException;
import util.DBConnectionUtil;
import util.QueryUtil;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CityServiceImpl implements ICityService {

    public static final Logger log = Logger.getLogger(CityServiceImpl.class.getName());

    private static Connection connection;
    private static Statement statement;
    private PreparedStatement preparedStatement;

    static {
        createCityTable();
    }

    public CityServiceImpl() {
    }

    public static void createCityTable() {
//		try {
//			connection = DBConnectionUtil.getDBConnection();
//			statement = connection.createStatement();
//
//			// drop table
//			//statement.executeUpdate(QueryUtil.queryByID("drop_table"));
//
//			// create table
//			//statement.executeUpdate(QueryUtil.queryByID("create_city_table"));
//
//		} catch (SAXException | IOException | ParserConfigurationException | ClassNotFoundException | SQLException var1) {
//			log.log(Level.SEVERE, var1.getMessage());
//		}

    }

    @Override
    public City getCityByID(int id) {
        return (City) this.actionOnCity(String.valueOf(id)).get(0);
    }

    @Override
    public ArrayList<City> getCitiesBySearch(String cityString) {
        ArrayList<City> cityList = new ArrayList();

        try {
            connection = DBConnectionUtil.getDBConnection();

            if (cityString != null && !cityString.isEmpty()) {
                cityString = cityString + "%";
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("city_by_search"));
                this.preparedStatement.setString(1, cityString);
            } else {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("all_cities"));
            }

            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                City city = new City();
                city.setID(resultSet.getInt(1));
                city.setName(resultSet.getString(2));
                city.setLatitude(resultSet.getFloat(3));
                city.setLongitude(resultSet.getFloat(4));
                cityList.add(city);
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

        return cityList;
    }

    @Override
    public City getCityByName(String name) {
        City city = new City();
        try {
            connection = DBConnectionUtil.getDBConnection();

            if (name != null && !name.isEmpty()) {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("city_by_name"));
                this.preparedStatement.setString(1, name);
            }

            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                city.setID(resultSet.getInt(1));
                city.setName(resultSet.getString(2));
                city.setLatitude(resultSet.getFloat(3));
                city.setLongitude(resultSet.getFloat(4));
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
        return city;
    }

    @Override
    public ArrayList<City> getCities() {
        return this.actionOnCity((String) null);
    }

    private ArrayList<City> actionOnCity(String cityID) {
        ArrayList<City> cityList = new ArrayList();

        try {
            connection = DBConnectionUtil.getDBConnection();

            if (cityID != null && !cityID.isEmpty()) {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("city_by_id"));
                this.preparedStatement.setString(1, cityID);
            } else {
                this.preparedStatement = connection.prepareStatement(QueryUtil.queryByID("all_cities"));
            }

            ResultSet resultSet = this.preparedStatement.executeQuery();

            while (resultSet.next()) {
                City city = new City();
                city.setID(resultSet.getInt(1));
                city.setName(resultSet.getString(2));
                city.setLatitude(resultSet.getFloat(3));
                city.setLongitude(resultSet.getFloat(4));
                cityList.add(city);
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

        return cityList;
    }
}
