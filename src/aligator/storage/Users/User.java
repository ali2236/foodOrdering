package aligator.storage.Users;


import org.json.JSONException;
import org.json.JSONObject;

public class User {
    private String username;
    private String password;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject userJson = new JSONObject();
        userJson.put("username",getUsername());
        userJson.put("password",getPassword());
        return userJson;
    }
}
