package com.aruna.javaorders.controllers;

import com.aruna.javaorders.models.Agent;
import com.aruna.javaorders.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    public AgentService agentService;

    //GET http://localhost:2023/customers/agent/9
    @GetMapping(value = "/agent/{agentId}",
            produces = {"application/json"})
    public ResponseEntity<?> findById(@PathVariable long agentId)
    {
        Agent myAgent = agentService.findById(agentId);
        return new ResponseEntity<>(myAgent, HttpStatus.OK);
    }

}
