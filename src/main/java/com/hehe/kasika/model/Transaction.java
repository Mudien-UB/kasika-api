package com.hehe.kasika.model;

import com.hehe.kasika.model.enums.PAYMENT_METHOD;
import com.hehe.kasika.model.enums.TRANSACTION_STATUS;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column( name = "created_at", updatable = false, nullable = false)
    private LocalDateTime createAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updateAt;

    @PrePersist
    public void prePersist() {
        createAt = LocalDateTime.now();
        updateAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updateAt = LocalDateTime.now();
    }

    @JoinColumn(name = "cashier_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users cashier;

    @Column(name = "cashier_name", length = 100, nullable = false)
    private String cashierName;

    @Column(name = "total_price", nullable = false)
    @Builder.Default
    private Double totalPrice = Double.NaN;

    @Column(name = "payment_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private PAYMENT_METHOD paymentMethod;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private TRANSACTION_STATUS status =  TRANSACTION_STATUS.PENDING;

    @Column(name = "note" )
    private String note;

}
