package lld.dropbox.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Folder implements StorageType {
    private String name;
    private List<File> fileList= new ArrayList<>();
    private List<Folder> folderList= new ArrayList<>();


    public Folder(String name) {
        this.name = name;
    }





}
