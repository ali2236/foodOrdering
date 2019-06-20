package aligator.controllers;

import aligator.file.FileServer;
import aligator.models.Pair;
import aligator.models.Receipt;
import aligator.navigation.Navigation;
import aligator.storage.users.UserManager;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class TrackingController {
    public Text msg_text;
    public TextField tracking_field;

    private ArrayList<Receipt> recipes = FileServer.getList(UserManager.getSafeUsername()+"-recipes");

    public void goToMain(ActionEvent event) {
        Navigation.to("main");
    }

    public void search(ActionEvent event){
        if (!tracking_field.getText().isEmpty()){
            Pair<Boolean,Receipt> result = searchForRecite(tracking_field.getText());
            if (result.first){ // success
                msg_text.setText("");
                Navigation.toDynamicDialog("receipt",result.second);
            } else { // no match
                msg_text.setText("نتیجه‌ای یافت نشد.");
            }
        }
    }

    private Pair<Boolean, Receipt> searchForRecite(String trackingCode){

        for (Receipt receipt: recipes){
            if (receipt!=null){
                if (receipt.getTrackingCode().equals(trackingCode)){
                    return new Pair<>(true, receipt);
                }
            }
        }
        return new Pair<>(false,null);
    }
}
