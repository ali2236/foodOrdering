package aligator.storage.Users;

public interface AuthCallback {
    void onSuccess();
    void onFail(String massage);
}
