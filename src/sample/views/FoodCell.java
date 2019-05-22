package sample.views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.text.Text;
import sample.models.Food;

import java.io.IOException;

public class FoodCell extends ListCell<Food> {
    @FXML
    public Text name;
    @FXML
    public Button more;
    @FXML
    public Button add_to_cart;

    public FoodCell(){
        loadFXML();
    }

    @FXML
    private void loadFXML(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../layouts/cell_food.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(Food item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        } else {
            name.setText(item.getName());
            // TODO: More button

            // TODO: add to card button

            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);

        }
    }

    @Override
    public void updateSelected(boolean selected) {
        //super.updateSelected(selected);
    }
}
