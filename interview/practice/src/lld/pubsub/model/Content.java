package lld.pubsub.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
//@AllArgsConstructor
@Setter
@Getter
public class Content {
    private String message;

    public Content(String content) {
        this.message = content;
    }

    public String getContent() {
        return message;
    }

}
