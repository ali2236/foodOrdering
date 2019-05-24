package aligator.lists.recite;

import aligator.models.Cart;
import aligator.models.Food;
import aligator.models.Recite;
import aligator.navigation.Navigation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.text.Text;

import java.io.IOException;

public class ReciteCell extends ListCell<Recite> {

    private Recite item;

    @FXML
    public Text date;
    @FXML
    public Text total;
    @FXML
    public Button show;

    public ReciteCell(){
        loadFXML();
    }

    @FXML
    private void loadFXML(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../../layouts/cell_recite.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(Recite item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
            this.item = null;
        } else {
            this.item = item;

            // set data
            date.setText(item.date.toString());
            total.setText(item.total.toString());
            show.setOnAction(this::onShowClicked);

            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        }
    }

    private void onShowClicked(ActionEvent event){
        Navigation.toDynamicDialog("recite",item);
    }

    @Override
    public void updateSelected(boolean selected) {
        //super.updateSelected(selected);
    }
}
