package com.fred.ordernotifications.controllers;

import com.fred.ordernotifications.models.events.OrderTriggerEvent;
import com.fred.ordernotifications.models.pipeline.OrderPipeline;
import com.fred.ordernotifications.services.OrderDraftCreator;
import com.google.common.cache.Cache;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Component
@Log4j2
public class OrderEventProcessor {
    final static Logger logger = LoggerFactory.getLogger(OrderEventProcessor.class);
    private final Cache<UUID, OrderPipeline> pipelineCache;
    private final OrderDraftCreator orderDraftCreator;

    public OrderEventProcessor(Cache<UUID, OrderPipeline> pipelineCache, OrderDraftCreator orderDraftCreator) {
        this.pipelineCache = pipelineCache;
        this.orderDraftCreator = orderDraftCreator;
    }

    @JmsListener(destination = "ordersQueue.q")
    public void receiveMessage(OrderTriggerEvent event) {
        logger.info("received message from queue: {}", event);
        actionOnEvent(event);
    }

    private void actionOnEvent(OrderTriggerEvent event) {
        OrderPipeline orderPipeline = new OrderPipeline();
        orderDraftCreator.processNextStep(orderPipeline, event);
        pipelineCache.put(orderPipeline.getId(), orderPipeline);
        log.info("Created pipeline with id {}", orderPipeline.getId());
    }
}
