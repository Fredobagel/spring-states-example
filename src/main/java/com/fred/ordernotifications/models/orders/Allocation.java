package com.fred.ordernotifications.models.orders;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Allocation {
    @Id
    @GeneratedValue
    private UUID id;

    private Long quantity;

    private String instrument;
}
