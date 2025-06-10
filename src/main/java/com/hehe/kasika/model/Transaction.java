package com.hehe.kasika.model;

import com.hehe.kasika.model.enums.PAYMENT_METHOD;
import com.hehe.kasika.model.enums.TRANSACTION_STATUS;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction extends ModelBase {

    @JoinColumn(name = "cashier_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User cashier;

    @Column(name = "cashier_name", length = 100, nullable = false)
    private String cashierName;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice = Double.NaN;

    @Column(name = "payment_method", nullable = false)
    @Enumerated(EnumType.STRING)
    private PAYMENT_METHOD paymentMethod;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TRANSACTION_STATUS status =  TRANSACTION_STATUS.PENDING;

    @Column(name = "note" )
    private String note;

}
