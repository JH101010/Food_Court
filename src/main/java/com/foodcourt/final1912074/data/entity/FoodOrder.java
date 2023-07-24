package com.foodcourt.final1912074.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
@Table(name = "food_order")
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @Column(nullable = false)
    private Long menuPrice;

    @Column(nullable = false)
    private String menuName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_num")
    private Customer customerNum;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "menu_num")
    private FoodMenu menuNum;
}
