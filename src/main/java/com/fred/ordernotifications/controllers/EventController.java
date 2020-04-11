package com.fred.ordernotifications.controllers;

import com.fred.ordernotifications.models.events.OrderTriggerEvent;
import com.fred.ordernotifications.services.JmsMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// This creates rest api endpoints. Normally the entry step.
@RestController
public class EventController {
    private final JmsMessageSender jmsMessageSender;

    // Autowiring in constructor allows whatever bean you've registered to be injected in automatically.
    @Autowired
    public EventController(JmsMessageSender jmsMessageSender) {
        this.jmsMessageSender = jmsMessageSender;
    }

    @PostMapping("/event")
    public Boolean sendEvent(@RequestBody OrderTriggerEvent event) {
        jmsMessageSender.sendMessage(event);
        return true;
    }
}
