package sample.controllers;

import com.sun.javafx.stage.StageHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.navigation.Navigation;
import sample.storage.SceneManager;
import sample.storage.Users.UserManager;

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


    }

    public void signUpButtonClick(ActionEvent event){
        Navigation.to("signup");
    }
}
