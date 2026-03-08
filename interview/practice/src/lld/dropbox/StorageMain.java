package lld.dropbox;

import lld.dropbox.model.File;
import lld.dropbox.model.Folder;
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

        File file2= new File(2, "notes.txt", "hi there, this is my new notes file");
        storageService.addFile(file2);
        System.out.println("main, the file has been added");
        File retrivedFile1= storageService.retrieveFile("notes.txt");
        System.out.println(" main, retrieved file content is  " + retrivedFile1.getContent());




//
        File file1= new File(3, "book.txt", "hi there, this is my book file");
        Folder folder= new Folder("new_folder");
        folder.getFileList().add(file1);

        storageService.addFolder(folder);
        System.out.println("main, the folder has been added");
        Folder retrivedFolder= storageService.retrieveFolder("new_folder");
        System.out.println(" main, retrieved folder name is  " + retrivedFolder.getName() + " and its contents are " + retrivedFolder.getFileList());


    }

}
