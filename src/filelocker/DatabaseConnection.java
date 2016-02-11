package filelocker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class contains all methods concerning connecting, querying and updating the database.
 * All methods use prepared statement to avoid SQL injection vulnerabilities.
 * @author xint
 */
public class DatabaseConnection {
      /**
       * Changes user status in database
       * @param name username of the account
       * @param status 0 for user, 1 for administrator
       */
    public static void setUserStatus(String name, int status) {
        String query = "UPDATE USERS SET user_status = ? WHERE user_name = ?";
        PreparedStatement pst = queryPrepState(query);
        try {
            pst.setInt(1, status);
            pst.setString(2, name);
            queryPrepState(query);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
     public static int getOTP(String username) {
        String query = "select user_otp from USERS WHERE "
                + "user_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, username);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
         return 0;
    }
    /**
     * Sets the user OTP status to 1. This means the OTP will expire after use. 
     * @param name name of user
     * @param temp 1 if password is OTP, 0 if password isn't an OTP
     */
    public static void setOTP(String name, int temp) {
        String query = "UPDATE USERS SET user_otp = ? WHERE user_name = ?";
        PreparedStatement pst = queryPrepState(query);
        try {
            pst.setInt(1, temp);
            pst.setString(2, name);
            queryPrepState(query);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Deletes file from database
 * @param filename name of file
 */
    public static void deleteFile(String filename) {
        try {
            String query = "delete from FILES where file_name = ?";
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, filename);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Searches database for users
 * @param name string to search database against
 */
    public static void searchUsers(String name) {
        try {
            String query = "select * from USERS WHERE user_name LIKE ?";
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, "%" + name + "%");
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                Logged.jComboBox1.removeAllItems();
                Logged.jComboBox1.addItem(result.getString("user_name"));
                while (result.next()) {
                    Logged.jComboBox1.addItem(result.getString("user_name"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Searches database for files of user
 * @param username name of user whose files will be searched
 */
    public static void searchFiles(String username) {
        Integer id = getUserIdByName(username);
        String query = "select file_name from FILES WHERE user_id = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setInt(1, id);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                Logged.jComboBox2.removeAllItems();
                Logged.jComboBox2.addItem(result.getString("file_name"));
                while (result.next()) {
                    Logged.jComboBox2.addItem(result.getString("file_name"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Checks whether username exists in database
 * @param username name to be checked
 * @return userExists true if user exists, false if user doesn't exist
 */
    public static boolean checkUsername(String username) {
        boolean userExists = false;
        String query = "select user_name from USERS WHERE "
                + "user_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, username);
            ResultSet result = pst.executeQuery();
            if (!result.next()) {
                userExists = false;
            } else {
                userExists = true;
            }
        } catch (Exception e) {
        }
        return userExists;
    }
/**
 * Checks if file of user exists in database
 * @param filename name of file to check
 * @return fileExists true if file exists, false if file doesn't exist
 */
    public static boolean checkFileName(String filename) {
        boolean fileExists = false;
        String query = "select file_name from FILES WHERE "
                + "file_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, filename);
            ResultSet result = pst.executeQuery();
            if (!result.next()) {
                fileExists = false;
            } else {
                fileExists = true;
            }
        } catch (Exception e) {

        }
        return fileExists;
    }
/**
 * Searches database for key bytes of file of user from database
 * @param file_name name of file to get key bytes of
 * @return key bytes of given file
 */
    public static byte[] getKeyBytes(String file_name) {
        String query = "select file_keybytes from FILES WHERE "
                + "file_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, file_name);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return result.getBytes(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Gets the salt of the file of the user from database
 * @param file_name name of file to get salt of
 * @return salt of file in bytes
 */
    public static byte[] getSaltFile(String file_name) {
        String query = "select file_salt from FILES WHERE "
                + "file_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, file_name);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return result.getBytes(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Gets salt of user from database
 * @param username name of user to get salt
 * @return salt of user in bytes
 */
    public static byte[] getSalt(String username) {
        String query = "select user_salt from USERS WHERE "
                + "user_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, username);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return result.getBytes(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Gets the count of wrong password inputs of user for file from database
 * @param filename name of file to get counter
 * @return counter number of wrong passwords inputted
 */
    public static Integer getFileCounter(String filename) {
        String query = "select file_counter from FILES WHERE file_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, filename);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                Integer counter = result.getInt("file_counter");
                return counter;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
/**
 * Gets counter of wrong inputted passwords for user account from database
 * @param username name of user
 * @return counter number of wrong inputs for user's password
 */
    public static Integer getUserCounter(String username) {
        String query = "select user_counter from USERS WHERE user_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, username);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                Integer counter = result.getInt("user_counter");
                return counter;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
/**
 * Gets email of user from database
 * @param username name of user
 * @return email string of user
 */
    public static String getEmail(String username) {
        String query = "select user_email from USERS WHERE "
                + "user_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, username);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return result.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Gets status of the user from database. 0 signifies user, 1 signifies administrator
 * @param username name of user
 * @return integer 0 for user, 1 for administrator
 */
    public static Integer getUserStatus(String username) {
        String query = "select user_status from USERS WHERE "
                + "user_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, username);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return result.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
/**
 * Gets user id given a username from database
 * @param username name of user to get id
 * @return integer id of user
 */
    public static Integer getUserIdByName(String username) {
        String query = "select user_id from USERS WHERE user_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, username);
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return Integer.parseInt(result.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
/**
 * Gets user id from database based on current user logged in.
 * @return integer id of user
 */
    public static Integer getUserId() {
        String query = "select user_id from USERS WHERE user_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, MyData.getUsername());
            ResultSet result = pst.executeQuery();
            if (result.next()) {
                return Integer.parseInt(result.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
/**
 * Inserts file into database.
 * @param f name of file
 * @param user_id id of user
 * @param password hashed password of file
 * @param salt hashed salt of file
 * @param keyBytes key bytes of key of file
 */
    public static void insertFile(String f, Integer user_id, String password, byte[] salt, byte[] keyBytes) {
        try {
            String query = "insert into FILES (file_name, file_password, user_id, file_salt, file_keyBytes, file_counter) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, f);
            pst.setString(2, password);
            pst.setInt(3, user_id);
            pst.setBytes(4, salt);
            pst.setBytes(5, keyBytes);
            pst.setInt(6, 0);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/**
 * Inserts an account into the database.
 * @param username name of user
 * @param password hashed password of user
 * @param email email address of user
 * @param salt hashed salt of user
 */
    public static void insertAccount(String username, String password, String email, byte[] salt) {
        String query = "insert into USERS (user_name, user_password, user_email, user_salt, user_counter) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, email);
            pst.setBytes(4, salt);
            pst.setInt(5, 0);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/**
 * Checks the user inputted password against database password of file.
 * @param file_name name of file
 * @param password password of user input
 * @param salt of file
 * @return isPass boolean true if password matches DB false if it doesn't
 */
    public static boolean checkFilePassword(String file_name, String password, byte[] salt) {
        Boolean isPass = false;
        String query = "select file_password from FILES WHERE file_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, file_name);
            ResultSet result = pst.executeQuery();
            if (!result.next()) {
                isPass = false;
            } else {
                String passwordDB = result.getString("file_password");
                String temp = Encrypt.hash(password, salt);
                if (passwordDB.equals(temp)) {
                    isPass = true;
                    resetFileCounter(file_name);
                } else {
                    incrementFileCounter(file_name);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isPass;
    }
/**
 * Checks if username, password of user match database entry.
 * Increments user counter if password is incorrect. Resets counter if password is correct.
 * @param username name of user
 * @param password password of user
 * @param salt user's salt
 * @return isUser boolean true if user credentials match, false if they do not
 */
    public static boolean checkLogin(String username, String password, byte[] salt) {

        Boolean isUser = false;
        String query = "select user_name, user_password, user_salt from USERS WHERE user_name = ?";
        try {
            PreparedStatement pst = queryPrepState(query);
            pst.setString(1, username);
            ResultSet result = pst.executeQuery();
            if (!result.next()) {
                isUser = false;
            } else {
                String usernameDB = result.getString("user_name");
                String passwordDB = result.getString("user_password");
                String temp = Encrypt.hash(password, salt);
                if (username.equals(usernameDB) && passwordDB.equals(temp)) {
                    isUser = true;
                    resetCounter(username);
                    MyData.setUsername(username);
                } else if (username.equals(usernameDB) && !passwordDB.equals(temp)) {
                    incrementCounter(username);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isUser;
    }
/**
 * Resets counter for file in database.
 * @param name name of file
 */
    public static void resetFileCounter(String name) {
        try {
            Integer newCounter = 0;
            String query = "UPDATE FILES SET file_counter = ? WHERE file_name = ?";
            PreparedStatement pst = queryPrepState(query);
            pst.setInt(1, newCounter);
            pst.setString(2, name);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
 * Resets counter of user account in database
 * @param name name of user
 */
    public static void resetCounter(String name) {
        Integer newCounter = 0;
        String query = "UPDATE USERS SET user_counter = ? WHERE user_name = ?";
        PreparedStatement pst = queryPrepState(query);
        try {
            pst.setInt(1, newCounter);
            pst.setString(2, name);
            queryPrepState(query);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Increments counter for user account in database.
 * @param name name of user
 */
    public static void incrementCounter(String name) {
        Integer prevCounter = getUserCounter(name);
        Integer newCounter = prevCounter + 1;
        String query = "UPDATE USERS SET user_counter = ? WHERE user_name = ?";
        PreparedStatement pst = queryPrepState(query);
        try {
            pst.setInt(1, newCounter);
            pst.setString(2, name);
            queryPrepState(query);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Increments counter for file of user in database.
 * @param name name of file
 */
    public static void incrementFileCounter(String name) {
        Integer prevCounter = getFileCounter(name);
        Integer newCounter = prevCounter + 1;
        String query = "UPDATE FILES SET file_counter = ? WHERE file_name = ?";
        PreparedStatement pst = queryPrepState(query);
        try {
            pst.setInt(1, newCounter);
            pst.setString(2, name);
            queryPrepState(query);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Changes the file name of user in database.
 * @param filenameNEW new name of file
 * @param filenameOLD previous name of file
 */
    public static void changeFilename(String filenameNEW, String filenameOLD) {
        String query = "UPDATE FILES SET file_name = ? WHERE file_name = ?";
        PreparedStatement pst = queryPrepState(query);
        try {
            pst.setString(1, filenameNEW);
            pst.setString(2, filenameOLD);
            queryPrepState(query);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Change user name of account in database.
 * @param usernameNEW new user name
 * @param usernameOLD previous user name
 */
    public static void changeUsername(String usernameNEW, String usernameOLD) {
        String query = "UPDATE USERS SET user_name = ? WHERE user_name = ?";
        PreparedStatement pst = queryPrepState(query);
        try {
            pst.setString(1, usernameNEW);
            pst.setString(2, usernameOLD);
            queryPrepState(query);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
/**
 * Changes the password of a user account in database.
 * @param username name of user
 * @param password password of user
 * @param salt salt of user
 */
    public static void changeAccountPassword(String username, String password, byte[] salt) {
        String query = "UPDATE USERS SET user_password = ?, user_salt = ? WHERE user_name = ?";
        PreparedStatement pst = queryPrepState(query);
        try {
            pst.setString(1, password);
            pst.setBytes(2, salt);
            pst.setString(3, username);
            queryPrepState(query);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
 * Changes the password for a file of a user in database.
 * @param filename name of file
 * @param password password of file
 * @param salt salt of file
 */
    public static void changeFilePassword(String filename, String password, byte[] salt) {
        String query = "UPDATE FILES SET file_password = ?, file_salt = ? WHERE file_name = ?";
        PreparedStatement pst = queryPrepState(query);
        try {
            pst.setString(1, password);
            pst.setBytes(2, salt);
            pst.setString(3, filename);
            queryPrepState(query);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
 * Changes the email of a user in database.
 * @param username name of user
 * @param email new email of user
 */
    public static void changeEmail(String username, String email) {
        String query = "UPDATE USERS SET user_email = ? WHERE user_name = ?";
        PreparedStatement pst = queryPrepState(query);
        try {
            pst.setString(1, email);
            pst.setString(2, username);
            queryPrepState(query);
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
//local derby database
//    public static PreparedStatement queryPrepState(String query) {
//        try {
//            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/filelocker;create=true", "username", "password");
//            PreparedStatement pst = conn.prepareStatement(query);
//            return pst;
//        } catch (ClassNotFoundException | SQLException e) {
//
//        }
//        return null;
//    }

//    public static ResultSet queryNormal(String query) {
//        try {
//            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/filelocker;create=true", "username", "password");
//            java.sql.Statement st = conn.createStatement();
//            return st.executeQuery(query);
//        } catch (ClassNotFoundException | SQLException e) {
//
//        }
//        return null;
//    }
    //db4free database online :::
//    public static ResultSet queryNormal(String query) {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/filelocker?zeroDateTimeBehavior=convertToNull", "filelocker", "filelocker");
//            java.sql.Statement st = conn.createStatement();
//            return st.executeQuery(query);
//        } catch (ClassNotFoundException | SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
/**
 * Sets up connection to database for prepared statement queries and updates.
 * @param query SQL string query
 * @return PreparedStatement
 */
    public static PreparedStatement queryPrepState(String query) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/filelocker?zeroDateTimeBehavior=convertToNull", "username", "password");
            PreparedStatement pst = conn.prepareStatement(query);
            return pst;
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }
}
