package com.aruna.javaorders.services;

import com.aruna.javaorders.models.Agent;
import com.aruna.javaorders.models.Customer;
import com.aruna.javaorders.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

@Transactional
@Service(value = "agentService")
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentrepos;

    @Override
    public Agent save(Agent agent) {
        Agent newagent = new Agent();
        newagent.setAgentname(agent.getAgentname());
        newagent.setCommission(agent.getCommission());
        newagent.setWorkingarea(agent.getWorkingarea());
        newagent.setPhone(agent.getPhone());
        newagent.setCountry(agent.getCountry());

        for(Customer c : agent.getCustomers()){

            newagent.getCustomers().add(new Customer(c.getCustname(),
                                                     c.getCustcity(),
                                                     c.getWorkingarea(),
                                                     c.getCustcountry(),
                                                     c.getGrade(),
                                                     c.getOpeningamt(),
                                                     c.getReceiveamt(),
                                                     c.getPaymentamt(),
                                                     c.getOutstandingamt(),
                                                     c.getPhone(),
                                                     c.getAgent()));
        }
        return agentrepos.save(newagent);
    }

    @Override
    public Agent findById(long id) {
        return agentrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agent id "+ id + " not found"));
    }
}
