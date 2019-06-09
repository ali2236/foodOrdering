package aligator.lists.receipt;

import aligator.models.Receipt;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class ReceiptCellFactory implements Callback<ListView<Receipt>, ListCell<Receipt>> {

    @Override
    public ListCell<Receipt> call(ListView<Receipt> param) {
        return new ReceiptCell();
    }
}
