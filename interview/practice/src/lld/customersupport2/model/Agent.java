package lld.customersupport2.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Agent implements Runnable {

    private final String id;
    private final BlockingQueue<Ticket> personalQueue = new LinkedBlockingQueue<>();
    private volatile boolean running = true;
    private Thread workerThread;

    public Agent(String id) {
        this.id = id;
    }

    public void start() {
        workerThread = new Thread(this);
        workerThread.start();
    }

    public void stop() {
        running = false;
        workerThread.interrupt();
    }

    public void assignTicket(Ticket ticket) {
        personalQueue.offer(ticket);
        ticket.setStatus(TicketStatus.ASSIGNED);
        System.out.println("Ticket " + ticket.getId() + " assigned to Agent " + id);
    }

    public int getLoad() {
        return personalQueue.size();
    }

    public String getId() {
        return id;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Ticket ticket = personalQueue.take();
                process(ticket);
            } catch (InterruptedException e) {
                System.out.println("Agent " + id + " interrupted");            }
        }
        System.out.println("Agent " + id + " stopped.");
    }

    private void process(Ticket ticket) {
        ticket.setStatus(TicketStatus.IN_PROGRESS);

        System.out.println("Agent " + id + " processing " + ticket.getId());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ticket.setStatus(TicketStatus.COMPLETED);

        System.out.println("Agent " + id + " completed " + ticket.getId());
    }
}