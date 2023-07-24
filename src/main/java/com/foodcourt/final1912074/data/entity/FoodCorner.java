package com.foodcourt.final1912074.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
//@ToString(exclude = "cornerName")
@Table(name = "food_corner")
public class FoodCorner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corner_num")
    private Long cornerNum;

    @Column(nullable = false)
    private String cornerName;

    @JsonIgnore
    @OneToMany(mappedBy = "cornerNum", cascade = CascadeType.REMOVE)
    private List<FoodMenu> children;
}
