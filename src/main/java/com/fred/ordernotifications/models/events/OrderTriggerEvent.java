package com.fred.ordernotifications.models.events;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

// Lombok - Data generates Getters, Setters and implements Equals method automatically without making your model
// 200 lines long
@Data
public class OrderTriggerEvent implements Serializable {
    private static final long serialVersionUID = 4L;

    private String id;

    private OrderTriggerEventType eventType;

    private LocalDateTime timestamp;
}
