package com.app.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GuaranteeComponents {
    @Id
    @GeneratedValue
    private Long id;
    private Integer guarantee_components;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id")
    private Product product;

    @ElementCollection
    @CollectionTable(name = "EGuaranties", joinColumns = @JoinColumn(name = "guarantee_components_id"))
    @Column(name = "gurantee_components")
    List<EGuarantee> eGuarantees;

}
