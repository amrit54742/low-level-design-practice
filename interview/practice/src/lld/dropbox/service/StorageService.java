package lld.dropbox.service;

import lld.dropbox.model.File;
import lld.dropbox.model.Folder;
import lld.dropbox.strategy.StorageStrategy;

public class StorageService {
    public static StorageService instance;
    private StorageStrategy storageStrategy;

    public StorageService(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public static StorageService getInstance(StorageStrategy storageStrategy){
        if(instance==null){
            instance= new StorageService(storageStrategy);
            return instance;
        } else {
            return instance;
        }
    }

    public void addFile(File file){
        storageStrategy.storeFile(file);
    }

    public File retrieveFile(String fileName){
        return storageStrategy.retreiveFile(fileName);
    }

    public void addFolder(Folder folder){
        storageStrategy.storeFolder(folder);
    }

    public Folder retrieveFolder(String folderName){
        return storageStrategy.retrieveFolder(folderName);
    }


}
