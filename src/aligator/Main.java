package aligator;

import aligator.file.FileServer;
import aligator.file.RegisterFile;
import aligator.models.Drink;
import aligator.models.Meal;
import javafx.application.Application;
import javafx.stage.Stage;
import aligator.models.Restaurant;
import aligator.navigation.RegisterNavigation;
import aligator.navigation.Navigation;
import aligator.storage.Storage;

import java.io.File;
import java.util.Arrays;

public class Main extends Application implements RegisterNavigation, RegisterFile {

    @Override
    public void start(Stage primaryStage){
        seed();
        addPrimaryStage(primaryStage);
        addPages();
        addFiles();
        Navigation.to("main");
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
        Navigation.addDynamicDialogPage("recite",BaseAddress + "dialog_recite.fxml");
        Navigation.addDynamicPage("shop",BaseAddress+"page_shop.fxml");
    }

    @Override
    public void addFiles() {
        final String BaseAddress = "data/";
        File file = new File(BaseAddress);
        if (!file.exists()){
            file.mkdir();
        }
        FileServer.addAppFile("recites",BaseAddress + "recites.smg");
        FileServer.addAppFile("tracking",BaseAddress + "tracking.smg");
    }

    private void seed(){
        Restaurant r1 = new Restaurant("تک فود","012547852", Arrays.asList(
                new Drink("نوشابه صورتی",9.999,10,false,0.200),
                new Drink("چای نعناعی",15.999,10,true,1),
                new Meal("کباب 100% گوسفندی",5.000,10,true,1),
                new Meal("چلو گلاب",6.500,10,true,1),
                new Meal("سالاد شیخ",52.000,10,true,5)
        ));

        Restaurant r2 = new Restaurant("فودستان","012547852", Arrays.asList(
                new Drink("قهوه تلخ",7.000,10,true,0.300),
                new Drink("آب مزمز",1.000,10,false,0.100),
                new Meal("ساندویچ متروباس",21.000,10,false,1)
        ));

        Restaurant r3 = new Restaurant("پلوماز","2415871247", Arrays.asList(
                new Drink("نوشابه بدون گاز",10.000,10,false,1.5),
                new Meal("کینگ سوپ",60.000,1,true,4),
                new Meal("شاه پیاز",50.000,2,false,1),
                new Meal("حلوا مکزیکی",12.000,20,false,1)
        ));

        Storage.restaurants.add(r1);
        Storage.restaurants.add(r2);
        Storage.restaurants.add(r3);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
