package aligator.storage.Users;

import aligator.file.FileServer;

import java.io.File;
import java.io.IOException;

public class UserManager {
    private static String signedInUsername;
    public static String getCurrentUsername(){
        return signedInUsername;
    }

    public static String getSafeUsername(){
        String safe = signedInUsername.replace("@","_");
        safe = safe.replace(".","_");
        safe = safe.replace("\\","");
        safe = safe.replace("?","");
        safe = safe.replace("%","");
        safe = safe.replace("*","");
        safe = safe.replace(":","_");
        safe = safe.replace("|","_");
        safe = safe.replace("\"","");
        safe = safe.replace(">","");
        safe = safe.replace("<","");

        return safe;
    }

    public static void setUser(String username) {
        UserManager.signedInUsername = username;
        // make Receipt files
        final String BaseAddress = "data/";
        File file = new File(BaseAddress+getSafeUsername()+"-recipes.smg");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileServer.addAppFile(getSafeUsername()+"-recipes",BaseAddress+getSafeUsername()+"-recipes.smg");
    }
}
