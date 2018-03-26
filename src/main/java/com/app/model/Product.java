package com.app.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name","category_id","producer_id}"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private BigDecimal Price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "producer_id")
    private Producer producer;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "product")
    private Set<Stock> stocks = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "product")
    private Set<GuaranteeComponents> guarantee_components = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "product")
    private Set<CustomerOrder> customer_orders = new LinkedHashSet<>();
}
