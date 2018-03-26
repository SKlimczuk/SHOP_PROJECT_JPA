package com.app.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "trade_id", "country_id"})})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "trade_id")
    private Trade trade;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "producer")
    private Set<Product> products = new LinkedHashSet<>();
}
