package aligator.lists.recite;

import aligator.models.Recite;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ReciteCellFactory implements Callback<ListView<Recite>, ListCell<Recite>> {

    @Override
    public ListCell<Recite> call(ListView<Recite> param) {
        return new ReciteCell();
    }
}
