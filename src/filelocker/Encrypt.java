package filelocker;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * This class contains methods concerning encryption/decryption, hashing, and salt generation.
 * @author xint
 */
public class Encrypt {
/**
 * Generates a random array of bytes using a CSPRNG
 * @return byte salt a new generated salt
 */
    public static byte[] salt() {
// salt protects against rainbow tables, precomputed hash tables
        try {
            SecureRandom sr = new SecureRandom();
            byte[] salt = new byte[24];
            sr.nextBytes(salt);
            return salt;
        } catch (Exception e) {
        }
        return null;
    }
/**
 * Hashed password and adds salt to it
 * @param password the user's password
 * @param salt random generated array of bytes
 * @return hash and salted password
 */
    public static String hash(String password, byte[] salt) {
        try {
            char[] temp = password.toCharArray();
            //temp is the password which the key is derived from
            //salt is the rng bytes to avoid rainbow table attacks
            // 1000 iterations slows down brute force attacks
            PBEKeySpec spec = new PBEKeySpec(temp, salt, 1000, 24 * 8);
            //PBKDF2 keystretching algorithm, HMAC secret key included in hash
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = skf.generateSecret(spec).getEncoded();
            return convertToHex(salt) + ":" + convertToHex(hash);
        } catch (Exception e) {
        }
        return null;
    }
/**
 * Converts array of bytes to hexadecimal string
 * @param bytes array of bytes to be converted
 * @return hexadecimal string
 */
    public static String convertToHex(byte[] bytes) {
        BigInteger temp = new BigInteger(1, bytes);
        String hex = temp.toString(16);
        int padding = (bytes.length * 2) - hex.length();
        if (padding > 0) {
            return String.format("%0" + padding + "d", 0) + hex;
        } else {
            return hex;
        }
    }
/**
 * Encrypts a file with AES
 * @param file_password the password user inputs for file
 * @param input the file input stream of the file to encrypt
 * @param output the file output stream of the new encrypted file
 * @param salt the salt associated with the password for file
 * @return the key bytes of the file, to be used for decryption
 */
    public static byte[] encryptFile(String file_password, InputStream input, OutputStream output, byte[] salt) {
        try {

            SecretKeyFactory fac = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            KeySpec keySpec = new PBEKeySpec(file_password.toCharArray(), salt, 1024, 128);
            SecretKey tempKey = fac.generateSecret(keySpec);
            SecretKey key = new SecretKeySpec(tempKey.getEncoded(), "AES");
            byte[] iv = new byte[16];
            IvParameterSpec aps = new IvParameterSpec(iv);
            Cipher myCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            
            myCipher.init(Cipher.ENCRYPT_MODE, key, aps);
            byte[] buf = new byte[1024];
            output = new CipherOutputStream(output, myCipher);
            int numRead = 0;
            while ((numRead = input.read(buf)) >= 0) {
                output.write(buf, 0, numRead);
            }
            input.close();
            output.close();
            byte[] keyBytes = key.getEncoded();
            return keyBytes;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Decrypts an encrypted file with AES
 * @param file_password the password of the file
 * @param input the encrypted file input stream
 * @param output the decrypted file output stream
 * @param salt the salt associated to the password of the file
 * @param keyBytes the key bytes used to decrypt the file
 */
    public static void decryptFile(String file_password, InputStream input, OutputStream output, byte[] salt, byte[] keyBytes) {
        try {
            SecretKey key = new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");
            byte[] iv = new byte[16];
            IvParameterSpec aps = new IvParameterSpec(iv);
            Cipher myCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            System.out.println("key on decrypt is ::: " + key);
            myCipher.init(Cipher.DECRYPT_MODE, key, aps);
            byte[] buf = new byte[1024];
            input = new CipherInputStream(input, myCipher);
            int numRead = 0;
            while ((numRead = input.read(buf)) >= 0) {
                output.write(buf, 0, numRead);
            }
            input.close();
            output.close();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
