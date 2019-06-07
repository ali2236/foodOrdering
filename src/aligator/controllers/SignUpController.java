package aligator.controllers;


import aligator.storage.Users.Status;
import aligator.storage.Users.UserAPI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import aligator.navigation.Navigation;
import aligator.storage.Users.UserManager;
import javafx.scene.text.Text;

public class SignUpController {

    public TextField first_name_field;
    public TextField last_name_field;
    public PasswordField email_field;
    public PasswordField phone_field;
    public PasswordField password_field;
    public PasswordField confirm_password_field;
    public Button signup_button;
    public Button signin_button;
    public Text error_text;

    private static Status emptyFormError = new Status(false,"یکی یا بیشتر از فرم‌ها خالی هستند.");

    public void onSignUpButtonClicked(ActionEvent event){

        Status formValidity = isFormValid();
        if (!formValidity.isSuccessful){ // show error
            showMassage(formValidity);
        } else { // signUp
            UserAPI userAPI = new UserAPI();
            Status signupStatus = userAPI.userSignup(
                    first_name_field.getText(),
                    last_name_field.getText(),
                    email_field.getText(),
                    phone_field.getText(),
                    password_field.getText()
            );
            if (!signupStatus.isSuccessful){ // show error
                showMassage(signupStatus);
            } else { // TODO: signup successful

            }
        }
    }

    public void onLoginButtonClicked(ActionEvent event){
        Navigation.to("login");
    }

    private Status isFormValid(){
        if (first_name_field.getText().isEmpty())return emptyFormError;
        if (last_name_field.getText().isEmpty()) return emptyFormError;
        if (email_field.getText().isEmpty()) return emptyFormError;
        else {
            // regex for matching emails copied from google
            boolean valid = email_field.getText()
                    .matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");
            if (!valid) return new Status(false,"ایمیل وارد شده معتبر نیست.");
        }
        if (phone_field.getText().isEmpty()) return emptyFormError;
        else {
            // regex for 0********** number matching written by me
            boolean valid = email_field.getText().matches("^[0][0-9]{10}$");
            if (!valid) return new Status(false,"شماره تلفن وارد شده معتبر نیست.");
        }
        if (password_field.getText().isEmpty()) return emptyFormError;
        if (confirm_password_field.getText().isEmpty()) return emptyFormError;
        else if (!password_field.getText().equals(confirm_password_field.getText())) return new Status(false,
                "تکرار رمز عبور با رمز عبور مطابق نیست.");
        return new Status(true,"");
    }

    private void showMassage(Status status){
        if (!status.isSuccessful){ // error massage
            error_text.setText(status.massage);
        } else { //TODO

        }
    }
}
