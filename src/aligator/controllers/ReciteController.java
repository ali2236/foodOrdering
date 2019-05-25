package aligator.controllers;

import aligator.models.CartItem;
import aligator.models.CartItemTableItem;
import aligator.models.Recite;
import aligator.navigation.IDynamicPage;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ReciteController implements IDynamicPage {

    public TableView table;
    public TableColumn<CartItemTableItem, Integer> indices;
    public TableColumn<CartItemTableItem, String> names;
    public TableColumn<CartItemTableItem, Integer> counts;
    public TableColumn<CartItemTableItem, Double> prices;
    public TableColumn<CartItemTableItem, Double> totalPrices;
    private Recite recite;

    public Text items;
    public Text date;
    public Text username;
    public Text tracking;
    public Text total;


    @Override
    public void setObject(Object object) {
        recite = (Recite) object;

        date.setText(recite.date.toString());
        //setItems(recite.products);
        total.setText(recite.total.toString());
        tracking.setText("کد رهگیری : "+recite.getTrackingCode());
        configureTable(recite.products);
    }

    private void configureTable(List<CartItem> items){
        List<CartItemTableItem> tableItems = new ArrayList<>(items.size());
        int index = 1;
        for (CartItem cartItem : items){
            tableItems.add(new CartItemTableItem(index++,cartItem));
        }

        indices.setCellValueFactory(new PropertyValueFactory<>("index"));
        names.setCellValueFactory(new PropertyValueFactory<>("name"));
        counts.setCellValueFactory(new PropertyValueFactory<>("count"));
        prices.setCellValueFactory(new PropertyValueFactory<>("price"));
        totalPrices.setCellValueFactory(new PropertyValueFactory<>("total"));

        table.setItems(FXCollections.observableList(tableItems));
    }

    private void setItems(List<CartItem> items){
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        for (CartItem p: items){
            stringBuilder.append(index + ".");
            stringBuilder.append(p.item.getName());
            stringBuilder.append("\t\t");
            stringBuilder.append( String.format("%d * %.3f",p.amount,p.item.getPrice()));
            stringBuilder.append("\t\t");
            stringBuilder.append(String.format("%.3f",p.item.getPrice() * p.amount));
            stringBuilder.append('\n');
            index++;
        }
        this.items.setText(stringBuilder.toString());
    }
}
