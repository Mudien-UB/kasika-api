package com.hehe.kasika.model;

import com.hehe.kasika.model.enums.ROLE_USER;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends ModelBase {

    @Column(name = "username", length = 100, nullable = false)
    private String username;

    @Column(name = "phone_number", length = 12, nullable = false)
    private String phoneNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private ROLE_USER role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

}
