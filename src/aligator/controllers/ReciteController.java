package aligator.controllers;

import aligator.models.CartItem;
import aligator.models.Product;
import aligator.models.Recite;
import aligator.navigation.IDynamicPage;
import javafx.scene.text.Text;

import java.util.List;

public class ReciteController implements IDynamicPage {

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
        setItems(recite.products);
        total.setText(recite.total.toString());
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
