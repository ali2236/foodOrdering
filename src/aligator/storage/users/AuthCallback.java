package aligator.storage.users;

public interface AuthCallback {
    void onSuccess();
    void onFail(String massage);
}
