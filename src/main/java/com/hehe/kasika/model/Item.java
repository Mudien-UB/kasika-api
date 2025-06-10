package com.hehe.kasika.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Item extends ModelBase {

    @Column(nullable = false , length = 100)
    private String name;

    @Column(nullable = false)
    @Builder.Default
    private Double price = Double.NaN;

    @Column(nullable = false)
    private String unit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

}
