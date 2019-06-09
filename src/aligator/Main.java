package aligator;

import aligator.models.Drink;
import aligator.models.Meal;
import aligator.models.Restaurant;
import aligator.navigation.Navigation;
import aligator.navigation.RegisterNavigation;
import aligator.storage.Storage;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Arrays;

public class Main extends Application implements RegisterNavigation {

    @Override
    public void start(Stage primaryStage){
        seed();
        addPrimaryStage(primaryStage);
        addPages();
        Navigation.to("login");
    }

    @Override
    public void addPrimaryStage(Stage primaryStage) {
        Navigation.setPrimaryStage(primaryStage);
    }

    @Override
    public void addPages() {
        final String BaseAddress = "../layouts/";
        Navigation.addPage("login",BaseAddress + "page_login.fxml");
        Navigation.addPage("signup",BaseAddress + "page_signup.fxml");
        Navigation.addPage("main",BaseAddress + "page_main.fxml");
        Navigation.addPage("profile",BaseAddress + "page_profile.fxml");
        Navigation.addPage("tracking",BaseAddress+"page_tracking.fxml");
        Navigation.addDynamicPage("food",BaseAddress + "page_food.fxml");
        Navigation.addDialogPage("cart",BaseAddress + "dialog_cart.fxml");
        Navigation.addDynamicDialogPage("receipt",BaseAddress + "dialog_receipt.fxml");
        Navigation.addDynamicPage("shop",BaseAddress+"page_shop.fxml");
    }

    private void seed(){
        Restaurant r1 = new Restaurant("تک فود","012547852", Arrays.asList(
                new Drink("نوشابه صورتی",9999L,10,false,0.200),
                new Drink("چای نعناعی",15999L,10,true,1),
                new Meal("کباب 100% گوسفندی",5000L,10,true,1),
                new Meal("چلو گلاب",6500L,10,true,1),
                new Meal("سالاد شیخ",52000L,10,true,5)
        ));

        Restaurant r2 = new Restaurant("فودستان","012547852", Arrays.asList(
                new Drink("قهوه تلخ",7000L,10,true,0.300),
                new Drink("آب مزمز",1000L,10,false,0.100),
                new Meal("ساندویچ متروباس",21000L,10,false,1)
        ));

        Restaurant r3 = new Restaurant("پلوماز","2415871247", Arrays.asList(
                new Drink("نوشابه بدون گاز",10000L,10,false,1.5),
                new Meal("کینگ سوپ",60000L,1,true,4),
                new Meal("شاه پیاز",50000L,2,false,1),
                new Meal("حلوا مکزیکی",12000L,20,false,1)
        ));

        Storage.restaurants.add(r1);
        Storage.restaurants.add(r2);
        Storage.restaurants.add(r3);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
