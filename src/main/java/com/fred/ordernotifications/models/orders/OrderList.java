package com.fred.ordernotifications.models.orders;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class OrderList {
    @Id
    @GeneratedValue
    private UUID id;

    // Marking it OneToMany creates ID columns which allows joins
    @OneToMany(cascade = CascadeType.ALL)
    private List<Allocation> allocations;
}
