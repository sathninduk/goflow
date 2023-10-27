package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// This class is used to generate the MD5 hash
public class Md5 {
    private Md5() {
        // private constructor
    }

    public static String generate(String text) {
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Add password bytes to digest
            md.update(text.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // Convert the bytes to a hexadecimal string
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            // Return the complete hash
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
