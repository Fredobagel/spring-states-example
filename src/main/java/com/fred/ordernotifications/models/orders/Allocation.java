package com.fred.ordernotifications.models.orders;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Allocation {
    // Object-relational mappping - these maps to columns in a database.
    // You need to mark something as Id.
    // GeneratedValue is somewhat magical and requires some stack overflowing.
    // You can provide some sort class to automatically generate ids. In the case of UUID, hibernate auto generates it.
    @Id
    @GeneratedValue
    private UUID id;

    private Long quantity;

    private String instrument;
}
