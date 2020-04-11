package com.fred.ordernotifications.controllers;

import com.fred.ordernotifications.models.events.OrderTriggerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class OrderEventProcessor {
    final static Logger logger = LoggerFactory.getLogger(OrderEventProcessor.class);

    public OrderEventProcessor() {
    }

    @JmsListener(destination = "ordersQueue.q")
    public void receiveMessage(OrderTriggerEvent event) {
        logger.info("received message from queue: {}", event);
        actionOnEvent(event);
    }

    private void actionOnEvent(OrderTriggerEvent event) {
        switch (event.getEventType()) {
            case CashFlow:
            case Futures:

        }
    }
}
