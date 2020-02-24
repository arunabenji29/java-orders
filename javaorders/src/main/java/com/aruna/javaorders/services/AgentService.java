package com.aruna.javaorders.services;

import com.aruna.javaorders.models.Agent;

public interface AgentService {
    Agent save(Agent agent);

    Agent findById(long id);
}
