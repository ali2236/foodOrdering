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
import sample.storage.SceneManager;
import sample.storage.Users.UserManager;

import static java.lang.Thread.sleep;

public class LoginController {

    @FXML
    private Label msg;

    @FXML
    private TextField username_field;

    @FXML
    private PasswordField password_field;



    public void loginButtonClick(ActionEvent actionEvent){
        String username = username_field.getText();
        String password = password_field.getText();

        if (UserManager.SignIn(username,password)){
            msg.setText("Login Successful!");
            try {
                sleep(200);
                Parent p = FXMLLoader.load(getClass().getResource("../Layouts/NotePage.fxml"));
                Stage s = StageHelper.getStages().get(0);
                SceneManager.putScene(s.getScene());
                s.setScene(new Scene(p));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            msg.setText("Wrong username or password");
        }
    }

    public void signUpButtonClick(ActionEvent event){

    }
}
