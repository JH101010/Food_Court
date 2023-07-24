package com.foodcourt.final1912074.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
//@ToString(exclude = "customerName") // 차이를 모르겠음.
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerNum;

    @Column(nullable = false)
    private String customerName;

    @JsonIgnore
    @OneToMany(mappedBy = "customerNum", cascade = CascadeType.REMOVE)
    private List<FoodOrder> children;
}
