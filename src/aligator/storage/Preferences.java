package aligator.storage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Preferences {

    private static String DIR = "data/";
    private static String FILE = "data.properties";

    private static Properties load(){
        try {
            File dir = new File(DIR);
            if (!dir.exists()){
                dir.mkdir();
            }
            FileReader reader = new FileReader(DIR+FILE);
            Properties properties = new Properties();
            properties.load(reader);
            return properties;
        } catch (IOException e) {
            e.printStackTrace();
            return new Properties();
        }
    }

    private static void save(Properties properties){
        try {
            FileWriter writer = new FileWriter(DIR+FILE);
            properties.store(writer,"");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key){
        Properties properties = load();
        return properties.getProperty(key);
    }

    public static void put(String key,String value){
        Properties properties = load();
        properties.put(key,value);
        save(properties);
    }
}
