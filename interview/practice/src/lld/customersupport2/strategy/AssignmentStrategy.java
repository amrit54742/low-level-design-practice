package lld.customersupport2.strategy;


import lld.customersupport2.model.Agent;

import java.util.List;

public interface AssignmentStrategy {
    Agent selectAgent(List<Agent> agents);
}
