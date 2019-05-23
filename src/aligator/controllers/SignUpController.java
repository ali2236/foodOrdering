package aligator.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import aligator.navigation.Navigation;
import aligator.storage.Users.UserManager;

public class SignUpController {

    @FXML
    private TextField username_field;
    @FXML
    private TextField password_field;
    @FXML
    private TextField confirm_password_field;
    @FXML
    private Button signup_button;
    @FXML
    private Button signin_text;

    public void onSignUpButtonClicked(ActionEvent event){
        String username = username_field.getText();
        String password = password_field.getText();
        String confirmPassword = confirm_password_field.getText();

        // confirm matching passwords
        if (!password.equals(confirmPassword)) return;

        // confirm valid username
        if (!UserManager.validUsername(username)) return;

        // confirm valid password
        if (!UserManager.validPassword(password)) return;

        // confirm not a duplicate
        if (UserManager.isUsernameTaken(username)) return;

        // register the user in the database
        UserManager.signUp(username,password);
    }

    public void onLoginButtonClicked(ActionEvent event){
        Navigation.to("login");
    }
}
