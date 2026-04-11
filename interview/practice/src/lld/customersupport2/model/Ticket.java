package lld.customersupport2.model;

import java.util.UUID;

public class Ticket {
    private final String id;
    private final String description;
    private volatile TicketStatus status;

    public Ticket(String description) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.status = TicketStatus.OPEN;
    }

    public String getId() { return id; }
    public String getDescription() { return description; }

    public TicketStatus getStatus() { return status; }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }
}
