package sample.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.navigation.Navigation;

import static java.lang.Thread.sleep;

public class LoginController {

    @FXML
    private TextField username_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button login_button;

    @FXML
    private Button signup_button;


    public void loginButtonClick(ActionEvent actionEvent){
        String username = username_field.getText();
        String password = password_field.getText();

        Navigation.to("main");
    }

    public void signUpButtonClick(ActionEvent event){
        Navigation.to("signup");
    }
}
