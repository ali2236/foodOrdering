package aligator.file;

import java.util.ArrayList;
import java.util.List;

public class FileServer {

    private static List<AppFile> appFiles = new ArrayList<AppFile>();
    public static void addAppFile(String name, String address){
        appFiles.add(new AppFile(name, address));
    }

    public static Boolean appendData(String fileName){
        //TODO
        return false;
    }

    public static Boolean getData(String fileName){
        //TODO
        return false;
    }

    public static Boolean deleteData(String filename){
        //TODO
        return false;
    }

}
