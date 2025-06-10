package com.hehe.kasika.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "business")
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Business extends ModelBase {

    @Column(name = "name",length = 100, nullable = false)
    private String name;

    @Column(name = "phone_number", length = 13, nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "business", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> listUser;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Item> listItem;

}
