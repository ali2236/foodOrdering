package sample.storage.Users;

import sample.storage.Storage;

import java.util.ArrayList;

public class UserManager {
    private static ArrayList<User> Users = new ArrayList<User>();
    private static User signedInUser;

    public static Boolean SignIn(String username, String password){
        User user = getUser(username,password);
        if (user==null) return false;
        UserManager.signedInUser = user;
        return true;
    }

    public static Boolean signUp(String username, String password){
        // confirm valid username
        if (!UserManager.validUsername(username)) return false;

        // confirm valid password
        if (!UserManager.validPassword(password)) return false;

        // confirm not a duplicate
        if (UserManager.isUsernameTaken(username)) return false;

        Users.add(new User(username, password));
        return true;
    }

    public static User getCurrentUser(){
        return signedInUser;
    }

    public static Boolean isUsernameTaken(String username){
        for (User u : Users){
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static Boolean validUsername(String username){
        if (username.length() <= 3) return false;
        if (username.contains(" ")) return false;
        return true;
    }

    public static Boolean validPassword(String username){
        if (username.length() <= 8) return false;
        if (username.contains(" ")) return false;
        return true;
    }
    private static User getUser(String username, String password){
        for (User u: Users){
            if (u != null) {
                if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                    return u;
                }
            }
        }
        return null;
    }

}
