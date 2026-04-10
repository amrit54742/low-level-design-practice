package lld.customersupport.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Agent implements Runnable{
    private String id;
    private volatile boolean running;
    private Thread workerThread;
    private final BlockingQueue<Ticket> ticketsQueue;

    public Agent(String id, BlockingQueue<Ticket> tickets) {
        this.id = id;
//        this.running=true;
        this.ticketsQueue = tickets;
    }

    public void start(){
        this.running= true;
        this.workerThread = new Thread(this);
        this.workerThread.start();

    }
    public void stop(){
        this.running= false;
        workerThread.interrupt();
    }


    @Override
    public void run() {
        while(running){
            try {
                Ticket ticket = ticketsQueue.take();      //todo: you can either add condition to check the queue empty or not and if it's empty then wait(), otherwise continue the execution.
                processTicket(ticket);
            } catch (InterruptedException interruptedException){
                System.out.println("Agent thread of id: " + id +" is interrupted ");
            }
        }

    }

    void processTicket(Ticket ticket){
        ticket.setStatus(TaskStatus.IN_PROGRESS);
        System.out.println("Agent " + id + " processing ticket " + ticket.getId());
        try{
            System.out.println("Agent " + id + " have started execution " + ticket.getId());
            workerThread.sleep(1000);
        } catch (InterruptedException interruptedException){
            System.out.println("Agent thread of id: " + id +" is interrupted during ticket processing");
        }
        ticket.setStatus(TaskStatus.COMPLETED);
        System.out.println("Agent " + id + " completed ticket " + ticket.getId());
    }
}
