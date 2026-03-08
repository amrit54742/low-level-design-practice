package lld.dropbox.strategy;

import lld.dropbox.model.File;
import lld.dropbox.model.Folder;

import java.util.HashMap;
import java.util.Map;

public class LocalStorage implements StorageStrategy{

    private Map<String, File> fileStorage= new HashMap<>();

    @Override
    public void storeFile(File file) {
        if (!fileStorage.containsKey(file.getName())){
            System.out.println("adding file " + file.getName() + " to local storage");
            fileStorage.put(file.getName(), file);
        } else {
            System.out.println("file " + file.getName() + " is already there in local storage, so replacing it with the current new file");
            fileStorage.remove(file.getName());
            fileStorage.put(file.getName(), file);
        }
    }

    @Override
    public File retreiveFile(String fileName) {
        return fileStorage.get(fileName);
    }

//    @Override
//    public void storeFolder(Folder folder) {
//
//    }
//
//    @Override
//    public Folder retrieveFolder(String folderName) {
//        return null;
//    }


}
