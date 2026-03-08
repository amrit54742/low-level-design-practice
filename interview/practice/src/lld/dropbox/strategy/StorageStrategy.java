package lld.dropbox.strategy;

import lld.dropbox.model.File;
import lld.dropbox.model.Folder;

public interface StorageStrategy {

    void storeFile(File file);

    File retreiveFile(String fileName);

//    void storeFolder(Folder folder);
//
//    Folder retrieveFolder(String folderName);

    //todo: add methods for storing and retrieving folder.--



}
