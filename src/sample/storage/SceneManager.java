package sample.storage;

import com.sun.istack.internal.NotNull;
import javafx.scene.Scene;

public class SceneManager {

    public static void putScene(@NotNull Scene scene){
        Storage.scenes.push(scene);
    }

    public static Scene getLastScene(){
        return Storage.scenes.pop();
    }

}
