package lld.customersupport.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Ticket {
    private String id;
    private String description;
    private volatile TaskStatus status;
    public Ticket(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.status = TaskStatus.OPEN;
    }

}
