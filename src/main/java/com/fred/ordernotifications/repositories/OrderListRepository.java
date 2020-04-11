package com.fred.ordernotifications.repositories;

import com.fred.ordernotifications.models.orders.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderListRepository extends JpaRepository<OrderList, UUID> {
}
