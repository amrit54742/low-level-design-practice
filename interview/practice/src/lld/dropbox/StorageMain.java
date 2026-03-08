package lld.dropbox;

import lld.dropbox.model.File;
import lld.dropbox.service.StorageService;
import lld.dropbox.strategy.LocalStorage;

public class StorageMain {

    public static void main(String[] args) {
        StorageService storageService= StorageService.getInstance(new LocalStorage());
        File file= new File(1, "notes.txt", "hi there, this is my notes file");
        storageService.addFile(file);
        System.out.println("main, the file has been added");
        File retrivedFile= storageService.retrieveFile("notes.txt");
        System.out.println(" main, retrieved file content is  " + retrivedFile.getContent());


    }

}
