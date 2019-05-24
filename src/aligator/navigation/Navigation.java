package aligator.navigation;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Navigation {

    private static ArrayList<Page> pages = new ArrayList<Page>();

    public static void addPage(String name,String layoutAddress){
        Page page = new Page(name,layoutAddress);
        pages.add(page);
    }

    public static void addDynamicPage(String name,String layoutAddress){
        DynamicPage page = new DynamicPage(name, layoutAddress);
        pages.add(page);
    }

    public static void addDialogPage(String name,String layoutAddress) {
        DialogPage page = new DialogPage(name, layoutAddress);
        pages.add(page);
    }

    public static void addDynamicDialogPage(String name,String layoutAddress) {
        DynamicDialogPage page = new DynamicDialogPage(name, layoutAddress);
        pages.add(page);
    }

    public static void to(String pageName){
        Page page = getPage(pageName);
        setScene(page);
    }

    public static void toDynamic(String pageName,Object object){
        Page page = getPage(pageName);
        if (page instanceof DynamicPage){
            ((DynamicPage)page).setObject(object);
            setScene(page);
        }
    }

    public static void toDialog(String pageName) {
        Page page = getPage(pageName);
        if (page instanceof DialogPage){
            Stage stage = new Stage();
            Scene scene = page.createNew();
            stage.setScene(scene);
            stage.show();
            //stage.setResizable();
        }
    }

    public static void toDynamicDialog(String pageName,Object object){
        Page page = getPage(pageName);
        if (page instanceof DynamicDialogPage){
            ((DynamicDialogPage)page).setObject(object);
            Stage stage = new Stage();
            Scene scene = page.createNew();
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        }
    }

    private static Page getPage(String name){
        for (Page p : pages){
            if (p.nameEquals(name)){
                return p;
            }
        }
        throw new NavigationException("page not found or not registered");
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
