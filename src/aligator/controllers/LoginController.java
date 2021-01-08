package aligator.controllers;

import aligator.navigation.Navigation;
import aligator.storage.Preferences;
import aligator.storage.users.AuthCallback;
import aligator.storage.users.Status;
import aligator.storage.users.UserAPI;
import aligator.storage.users.UserManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class LoginController {

    public Text error_text;
    public TextField username_field;
    public PasswordField password_field;
    public Button login_button;
    public Button signup_button;

    private static Status emptyFormError = new Status(false, "یکی یا بیشتر از فرم‌ها خالی هستند.");

    private boolean pendingRequest = false;

    @FXML
    public void initialize(){
        username_field.setText(
                Preferences.get("last_username")
        );
    }

    public void loginButtonClick(ActionEvent actionEvent) {
        String username = username_field.getText();
        String password = password_field.getText();
        Status formStatus = isFormValid();
        if (!formStatus.isSuccessful) {
            showMassage(formStatus.massage);
            return;
        } else {
            showMassage("");
        }
        if (pendingRequest) return;
        UserAPI userAPI = new UserAPI();
        userAPI.userLoginParallel(username, password,
                new AuthCallback() {
                    @Override
                    public void onSuccess() {
                        UserManager.setUser(username);
                        pendingRequest = false;
                        Platform.runLater(() -> {
                            Preferences.put("last_username",username);
                            Navigation.to("main");
                        });
                    }

                    @Override
                    public void onFail(String massage) {
                        pendingRequest = false;
                        showMassage(massage);
                    }
                });

    }

    private void showMassage(String massage) {
        error_text.setText(massage);
    }

    private Status isFormValid() {
        if (username_field.getText().isEmpty()) return emptyFormError;
        if (password_field.getText().isEmpty()) return emptyFormError;
        return new Status(true, "");
    }

    public void signUpButtonClick(ActionEvent event) {
        Navigation.to("signup");
    }

    public void guestLogin(ActionEvent event) {
        String username = username_field.getText();
        if(username.isEmpty()){
            showMassage("نام کاربری نمی تواند خالی باشد!");
        } else {
            UserManager.setUser(username);
            Preferences.put("last_username", username);
            Navigation.to("main");
        }
    }
}
