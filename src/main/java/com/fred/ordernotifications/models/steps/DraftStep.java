package com.fred.ordernotifications.models.steps;

import com.fred.ordernotifications.models.events.OrderTriggerEvent;
import com.fred.ordernotifications.models.orders.OrderList;
import lombok.Data;

@Data
public class DraftStep extends StepBase{
    private OrderList orderList;

    public DraftStep(OrderList orderList, OrderTriggerEvent event) {
        this.orderList = orderList;
        setEventId(event.getId());
    }
}
