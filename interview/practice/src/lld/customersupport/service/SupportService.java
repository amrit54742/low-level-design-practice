package lld.customersupport.service;

import lld.customersupport.model.Agent;
import lld.customersupport.model.Ticket;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@NoArgsConstructor
public class SupportService {
    private static SupportService instance;

    // 🔥 GLOBAL SHARED QUEUE
    private final BlockingQueue<Ticket> ticketQueue = new LinkedBlockingQueue<>();

    private final List<Agent> agents = new ArrayList<>();
    public static SupportService getInstance(){
        if(instance == null){
            instance = new SupportService();
            return instance;
        } else {
            return instance;
        }
    }

    public void addAgent(String agentId){
        Agent agent= new Agent(agentId, ticketQueue);
        agents.add(agent);
        agent.start();

    }

    public void createTicket(String ticketDesc){
        Ticket ticket= new Ticket(ticketDesc);
        try {
            this.ticketQueue.put(ticket); // BLOCKING if full
            System.out.println("Ticket created: " + ticket.getId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public void shutdown() {
        for (Agent agent : agents) {
            agent.stop();
        }
    }
}
