package lld.customersupport2.service;

import lld.customersupport2.model.Agent;
import lld.customersupport2.model.Ticket;
import lld.customersupport2.model.TicketQueue;
import lld.customersupport2.strategy.AssignmentStrategy;

import java.util.List;

class Scheduler implements Runnable {

    private final TicketQueue ticketQueue;
    private final List<Agent> agents;
    private final AssignmentStrategy strategy;
    private volatile boolean running = true;
    private Thread schedulerThread;

    public Scheduler(TicketQueue queue, List<Agent> agents, AssignmentStrategy strategy) {
        this.ticketQueue = queue;
        this.agents = agents;
        this.strategy = strategy;
    }

    public void start() {
        schedulerThread = new Thread(this);
        schedulerThread.start();
    }

    public void stop() {
        running = false;
        schedulerThread.interrupt();
    }

    @Override
    public void run() {
        while (running) {
            try {
                Ticket ticket = ticketQueue.takeTicket();

                Agent agent = strategy.selectAgent(agents);

                if (agent != null) {
                    agent.assignTicket(ticket);
                }

            } catch (InterruptedException e) {
                if (!running) break;
            }
        }
        System.out.println("Scheduler stopped.");
    }
}