package aligator.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileServer {

    private static List<AppFile> appFiles = new ArrayList<AppFile>();
    public static void addAppFile(String name, String address){
        appFiles.add(new AppFile(name, address));
    }


    public static <T extends Serializable> ArrayList<T> getList(String fileName){
        File file = getAppFile(fileName).getFile();
        ArrayList<T> arrayList = new ArrayList<>();
        if (file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream);
                Object persistentObject = objectInputStream.readObject();
                if (persistentObject!=null) {
                        arrayList = (ArrayList<T>)persistentObject;
                }
                objectInputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public static <T extends Serializable> void putList(String fileName,ArrayList<T> arrayList){
        File file = getAppFile(fileName).getFile();
            try {
                if (!file.exists()){
                    System.out.printf(file.getAbsolutePath());
                    file.createNewFile();
                }

                FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream objectOutputStream =new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(arrayList);
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static <T extends Serializable> void appendItem(String fileName,T item){
        ArrayList<T> arrayList = getList(fileName);
        arrayList.add(item);
        putList(fileName,arrayList);
    }

    private static AppFile getAppFile(String fileName){
        for (AppFile f: appFiles){
            if (f!=null){
                if (f.getName().equals(fileName)){
                    return f;
                }
            }
        }
        throw new FileNotFoundException("could not find file in appFiles list.");
    }

}
