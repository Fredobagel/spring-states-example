package com.fred.ordernotifications.services;

import com.fred.ordernotifications.controllers.OrderEventProcessor;
import com.fred.ordernotifications.models.events.OrderTriggerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageSender {
    final static Logger logger = LoggerFactory.getLogger(OrderEventProcessor.class);

    private JmsTemplate jmsTemplate;

    public JmsMessageSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendMessage(OrderTriggerEvent orderTriggerEvent) {
        logger.info("sending event to queue");
        jmsTemplate.convertAndSend("ordersQueue.q", orderTriggerEvent);
    }
}
