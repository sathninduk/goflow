package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import service.rider.IRiderService;

public class CommonUtil {
    public static final Logger log = Logger.getLogger(IRiderService.class.getName());
    public static final Properties properties = new Properties();

    static {
        try {
            properties.load(QueryUtil.class.getResourceAsStream("config.properties"));
        } catch (IOException var1) {
            log.log(Level.SEVERE, var1.getMessage());
        }

    }

    public CommonUtil() {
    }

}
