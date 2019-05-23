package aligator.file;

import java.io.File;

public class AppFile {
    private String name;
    private String address;

    public AppFile(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public File getFile(){
        return new File(address);
    }

    public String getName() {
        return name;
    }
}
