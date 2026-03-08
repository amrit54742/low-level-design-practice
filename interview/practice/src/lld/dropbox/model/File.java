package lld.dropbox.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class File implements StorageSystem{
    private int fileId;
    private String name;
    private String content;
    private int size;

    public File(int fileId, String name, String content) {
        this.fileId = fileId;
        this.name = name;
        this.content = content;
        this.size= content.length();
    }
}
