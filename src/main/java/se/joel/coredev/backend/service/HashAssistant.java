package se.joel.coredev.backend.service;

import se.joel.coredev.backend.repository.data.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashAssistant {

    private static final String ALGORITHM = "SHA-256";

    public static User hashPassword(User user) throws NoSuchAlgorithmException {
        return new User(user.getUsername(), generateHash(user.getPassword(), ALGORITHM), user.getAuthority());
    }

    public static boolean comparePasswords(String passwordDatabase, String passwordSent) {
        String var1 = passwordDatabase;
        String var2 = "";
        try {
            var2 = generateHash(passwordSent, ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (var1.equals(var2)) {
            return true;
        }
        return false;
    }

    private static String generateHash(String data, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.reset();
        byte[] hash = digest.digest(data.getBytes());
        return bytesToStringHex(hash);
    }

    private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

    private static String bytesToStringHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int v = bytes[i] & 0xFF;
            hexChars[i * 2] = hexArray[v >>> 4];
            hexChars[i * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
}
