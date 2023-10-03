package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import service.IRiderService;

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

    public static String generateIDs(ArrayList<String> arrayList) {
        int next = arrayList.size();
        ++next;
        String id = "E300" + next;
        if (arrayList.contains(id)) {
            ++next;
            id = "E300" + next;
        }

        return id;
    }
}
