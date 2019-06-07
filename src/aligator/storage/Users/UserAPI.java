package aligator.storage.Users;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class UserAPI implements IUserAPI {

    private static Status programmingError = new Status(false,"خطایی پیش آمده!");
    private static Status serverOutOfReachError = new Status(false,"دسترسی به سرور امکان پذیر نیست.");
    private static Status sendingDataError = new Status(false,"در ارسال داده ها مشکلی پیش آمده.");
    private static Status receivingDataError = new Status(false,"در دریافت داده ها مشکلی پیش آمده.");

    @Override
    public Status userLogin(String username, String password)  {
        User user = new User(username, password);

        String userJson;
        URL loginURL;
        HttpURLConnection connection;
        OutputStream outputStream;
        InputStream inputStream;
        JSONObject responseJson;
        boolean status;
        String massage;

        try {
            userJson = user.toJson().toString();
        } catch (JSONException e){
            // programming error
            e.printStackTrace();
            return programmingError;
        }

        try {
            loginURL = new URL(baseURL + "login_user");
        } catch (MalformedURLException e) {
            // programming error
            e.printStackTrace();
            return programmingError;
        }

        try {
            connection = (HttpURLConnection) loginURL.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            return serverOutOfReachError;
        }

        try {
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.addRequestProperty("content-type","Application/json");
        } catch (ProtocolException e) {
            e.printStackTrace();
            return programmingError;
        }

        try {
            outputStream = connection.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return serverOutOfReachError;
        }

        try {
            outputStream.write(userJson.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return sendingDataError;
        }

        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return sendingDataError;
        }

        try {
            inputStream = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return receivingDataError;
        }

        Scanner scanner = new Scanner(inputStream);
        scanner.useDelimiter("//A");
        String response = scanner.next();

        try {
            responseJson = new JSONObject(response);
        } catch (JSONException e) {
            return new Status(false,"در داده های دریافتی مشکلی وجود دارد.");
        }

        try {
            status = responseJson.getBoolean("status");
            if (status) massage = response/* "successes"*/;
            else massage = responseJson.getString("error");
        } catch (JSONException e) {
            e.printStackTrace();
            return programmingError;
        }
        return new Status(status,massage);
    }

    @Override
    public Status userSignup(String firstName, String lastName, String email, String phone, String password) {
        JSONObject signupBody;
        URL signupURL;
        HttpURLConnection connection;
        OutputStream outputStream;
        InputStream inputStream;
        JSONObject responseJson;
        boolean status;
        String massage;

        try {
            signupBody = new JSONObject();
            signupBody.put("first_name", firstName);
            signupBody.put("last_name", lastName);
            signupBody.put("email", email);
            signupBody.put("phone", phone);
            signupBody.put("password", password);
        } catch (JSONException e){
            e.printStackTrace();
            return programmingError;
        }

        try {
            signupURL = new URL(baseURL + "signup_user");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return programmingError;
        }

        try {
            connection = (HttpURLConnection) signupURL.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
            return serverOutOfReachError;
        }

        try {
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.addRequestProperty("content-type","Application/json");
        } catch (ProtocolException e) {
            e.printStackTrace();
            return programmingError;
        }

        try {
            outputStream = connection.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return serverOutOfReachError;
        }

        try {
            outputStream.write(signupBody.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return sendingDataError;
        }

        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            return sendingDataError;
        }

        try {
            inputStream = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return receivingDataError;
        }

        Scanner scanner = new Scanner(inputStream);
        scanner.useDelimiter("//A");
        String response = scanner.next();

        try {
            responseJson = new JSONObject(response);
        } catch (JSONException e) {
            return new Status(false,"در داده های دریافتی مشکلی وجود دارد.");
        }

        try {
            status = responseJson.getBoolean("status");
            if (status) massage = response/* "successes"*/;
            else massage = responseJson.getString("error");
        } catch (JSONException e) {
            e.printStackTrace();
            return programmingError;
        }
        return new Status(status,massage);

        //return new Status(true,"ثبت نام با موفقیت انجام شد.");
    }
/* TEST
    public static void main(String[] args) {
        UserAPI api = new UserAPI();
        Status status = api.userSignup("ali","gator","aligator22236@gmail.com","09123456789","1234321");
        System.out.println(status.massage);
    }*/
}
