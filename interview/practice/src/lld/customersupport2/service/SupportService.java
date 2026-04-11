package lld.customersupport2.service;

import lld.customersupport2.model.Agent;
import lld.customersupport2.model.Ticket;
import lld.customersupport2.model.TicketQueue;
import lld.customersupport2.strategy.LeastLoadedStrategy;

import java.util.*;

public class SupportService {

    private static SupportService instance;

    private final TicketQueue queue = new TicketQueue();
    private final List<Agent> agents = new ArrayList<>();
    private final Scheduler scheduler;

    private SupportService() {
        scheduler = new Scheduler(queue, agents, new LeastLoadedStrategy());
    }

    public static synchronized SupportService getInstance() {
        if (instance == null) {
            instance = new SupportService();
        }
        return instance;
    }

    public void start() {
        scheduler.start();
    }

    public void addAgent(String id) {
        Agent agent = new Agent(id);
        agents.add(agent);
        agent.start();
    }

    public void createTicket(String desc) {
        Ticket ticket = new Ticket(desc);
        queue.addTicket(ticket);
        System.out.println("Created Ticket: " + ticket.getId());
    }

    public void shutdown() {
        scheduler.stop();
        for (Agent agent : agents) {
            agent.stop();
        }
    }
}
