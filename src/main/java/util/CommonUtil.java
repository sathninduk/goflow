package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import service.rider.IRiderService;

// This class is used to get the queries from the queries.xml file
public class CommonUtil {

    // logger object
    public static final Logger log = Logger.getLogger(IRiderService.class.getName());

    // properties object
    public static final Properties properties = new Properties();

    static { // static block
        try {
            properties.load(QueryUtil.class.getResourceAsStream("config.properties")); // load the properties file
        } catch (IOException var1) {
            log.log(Level.SEVERE, var1.getMessage()); // log the exception
        }

    }

    public CommonUtil() { // default constructor
    }

}
