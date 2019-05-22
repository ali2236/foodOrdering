package sample.navigation;

import com.sun.javafx.stage.StageHelper;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

public class Navigation {

    private static ArrayList<Page> Pages = new ArrayList<Page>();

    public static void to(AppPages page){
        for (Page p : Pages){
            if (p.type.equals(page)){
                setScene(p);
            }
        }
    }

    public static Stack<Scene> scenes = new Stack<Scene>();
    private static void setScene(Page page){

    }

    private static Stage getMainStage(){
        return StageHelper.getStages().get(0);
    }
}
