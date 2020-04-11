package com.fred.ordernotifications.controllers;

import com.fred.ordernotifications.models.orders.OrderList;
import com.fred.ordernotifications.repositories.OrderListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController("/orders")
public class OrderListController {

    private final OrderListRepository orderListRepository;

    @Autowired
    public OrderListController(OrderListRepository orderListRepository) {
        this.orderListRepository = orderListRepository;
    }

    @GetMapping("/orderList")
    public List<OrderList> getAllOrderLists() {
        return orderListRepository.findAll();
    }

    @GetMapping("/orderList/{orderListId}")
    public OrderList getOrderListById(@PathVariable("orderListId") String orderListId) {
        return orderListRepository.findById(UUID.fromString(orderListId)).orElse(null);
    }
}
