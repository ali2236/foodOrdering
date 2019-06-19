package aligator.storage.users;

public interface IUserAPI {
    String baseURL = "http://188.40.255.172:2001/api/user_api/";

    Status userLogin(String username, String password);
    Status userSignup(String firstName, String lastName, String email, String phone, String password);
}
