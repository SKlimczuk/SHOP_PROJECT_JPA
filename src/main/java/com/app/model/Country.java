package com.app.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {
    @Id
    @GeneratedValue
    Long id;
    String name;

    @OneToMany(cascade = CascadeType.PERSIST,  mappedBy = "country")
    Set<Customer> customers = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST,  mappedBy = "country")
    Set<Shop> shops = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.PERSIST,  mappedBy = "country")
    Set<Producer> producers = new LinkedHashSet<>();
}
