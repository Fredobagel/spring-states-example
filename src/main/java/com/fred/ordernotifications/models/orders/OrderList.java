package com.fred.ordernotifications.models.orders;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class OrderList {
    @Id
    @GeneratedValue
    private UUID id;

    // Marking it OneToMany creates ID columns which allows joins
    @OneToMany
    private List<Allocation> allocations;
}
