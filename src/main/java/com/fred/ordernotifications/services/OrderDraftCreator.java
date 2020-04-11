package com.fred.ordernotifications.services;

import com.fred.ordernotifications.models.events.OrderTriggerEvent;
import com.fred.ordernotifications.models.orders.Allocation;
import com.fred.ordernotifications.models.orders.OrderList;
import com.fred.ordernotifications.models.pipeline.OrderPipeline;
import com.fred.ordernotifications.models.steps.DraftStep;
import com.fred.ordernotifications.repositories.OrderListRepository;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class OrderDraftCreator {
    private final OrderListRepository orderListRepository;

    public OrderDraftCreator(OrderListRepository orderListRepository) {
        this.orderListRepository = orderListRepository;
    }

    public OrderPipeline processNextStep(OrderPipeline pipeline, OrderTriggerEvent event) {
        pipeline.getSteps().add(new DraftStep(createNewOrder(), event));
        return pipeline;
    }

    private OrderList createNewOrder() {
        OrderList orderList = new OrderList();
        Allocation allocation = new Allocation();
        orderList.setAllocations(Collections.singletonList(allocation));
        return orderListRepository.save(orderList);
    }
}
