package aligator.storage.Users;

public class Status {
    public final boolean isSuccessful;
    public final String massage;

    public Status(boolean isSuccessful, String massage) {
        this.isSuccessful = isSuccessful;
        this.massage = massage;
    }
}
