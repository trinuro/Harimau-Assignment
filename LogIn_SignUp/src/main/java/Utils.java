import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Khiew
 */
public class Utils {
    /**
     * Hash a string into SHA
     * @param input
     * @return
     * @throws NoSuchAlgorithmException 
     */
    public static byte[] getSHA(String input) throws NoSuchAlgorithmException{
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    
    private static String toHexString(byte[] hash){
         // Convert byte array into signum representation
         BigInteger number = new BigInteger(1, hash);

         // Convert message digest into hex value
         StringBuilder hexString = new StringBuilder(number.toString(16));

         // Pad with leading zeros
         while (hexString.length() < 64)
         {
                 hexString.insert(0, '0');
         }

         return hexString.toString();
    }  
    
    /**
     * Method to hash password based on SHA-256 
     * @param dateTime
     * @param password
     * @return 
     */
    public static String hashPassword(String dateTime, String password){
        String encryptedPassword;

        try{
            // Encrypt password and datetime with SHA hash
            encryptedPassword = toHexString(getSHA(password+dateTime));

        }catch (NoSuchAlgorithmException e) {
            System.out.println("Encryption failed.");
            System.out.println("Exception thrown for incorrect algorithm: " + e);
            return "Failed";
        }

        // return hash
        return encryptedPassword;
    }
}
