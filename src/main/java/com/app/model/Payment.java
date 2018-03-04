package com.app.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue
    private Long id;
    private Integer payment;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "payment")
    private Set<CustomerOrder> customer_orders = new LinkedHashSet<>();

    @ElementCollection
    @CollectionTable(name = "ePayment", joinColumns = @JoinColumn(name = "payment_id"))
    @Column(name = "payment")
    private List<EPayment> ePayments;
}
