package filelocker;

import java.util.ArrayList;

/**
 * MyData class stores information for current user and user files
 * @author xint
 */
public class MyData {
    static String username;
    static String email;
    static String file_path;
    static String file_name;
    static String file_dir;
    
    static ArrayList<ArrayList<String>> filesToEnc = new ArrayList<>();

    public static ArrayList<ArrayList<String>> getFilesToEnc() {
        return filesToEnc;
    }

    public static void setFilesToEnc(ArrayList<ArrayList<String>> fileToEnc) {
        MyData.filesToEnc = fileToEnc;
    }

   
   
// setters and getters for user and user files information
    public static String getFile_dir() {
        return file_dir;
    }

    public static void setFile_dir(String file_dir) {
        MyData.file_dir = file_dir;
    }
    
    public static String getFile_name() {
        return file_name;
    }

    public static void setFile_name(String file_name) {
        MyData.file_name = file_name;
    }
    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        MyData.email = email;
    }
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        MyData.username = username;
    }
    
    public static String getFile_path() {
        return file_path;
    }

    public static void setFile_path(String file_path) {
        MyData.file_path = file_path;
    }
    
}
