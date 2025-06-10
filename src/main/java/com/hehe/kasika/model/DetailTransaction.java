package com.hehe.kasika.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "detail_transaction")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailTransaction{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "transaction_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Transaction transaction;

    @JoinColumn(name = "item_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Column(name = "item_price", nullable = false)
    private Double itemPrice = Double.NaN;

    @Column(name = "quantity", nullable = false )
    private Double quantity = Double.NaN;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

}
