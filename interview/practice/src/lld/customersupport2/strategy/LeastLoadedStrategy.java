package lld.customersupport2.strategy;


import lld.customersupport2.model.Agent;

import java.util.List;

public class LeastLoadedStrategy implements AssignmentStrategy {

    @Override
    public Agent selectAgent(List<Agent> agents) {
        Agent best = null;

        for (Agent agent : agents) {
            if (best == null || agent.getLoad() < best.getLoad()) {
                best = agent;
            }
        }
        return best;
    }
}