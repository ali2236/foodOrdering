package sample.navigation;

import com.sun.javafx.stage.StageHelper;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Navigation {

    private static ArrayList<Page> pages = new ArrayList<Page>();

    public static void addPage(String name,String layoutAddress,Boolean recyclable){
        Page page = new Page(name,layoutAddress,recyclable);
        pages.add(page);
    }

    //private static String lastPageName;
    public static void to(String pageName){
        Page page = getPage(pageName);
        setScene(page);
    }

    private static Page getPage(String name){
        for (Page p : pages){
            if (p.nameEquals(name)){
                return p;
            }
        }
        throw new NavigationException("page not found");
    }

    //private static Stack<Scene> scenes = new Stack<Scene>();
    private static void setScene(Page page){
        Stage mainStage = getMainStage();
        mainStage.setScene(page.createNew());
    }

    private static Stage _primaryStage;
    private static Stage getMainStage(){
        return _primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        _primaryStage = primaryStage;
        _primaryStage.setScene(new Scene(new AnchorPane()));
        _primaryStage.show();
    }
}
