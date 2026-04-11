package lld.customersupport2.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TicketQueue {
    private final BlockingQueue<Ticket> queue = new LinkedBlockingQueue<>();

    public void addTicket(Ticket ticket) {
        queue.offer(ticket);
    }

    public Ticket takeTicket() throws InterruptedException {
        return queue.take();
    }
}