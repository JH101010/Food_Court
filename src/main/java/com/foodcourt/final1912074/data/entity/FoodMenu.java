package com.foodcourt.final1912074.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
@Table(name = "food_menu")
public class FoodMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuNum;

    @Column(nullable = false)
    private String menuName;

    @Column(nullable = false)
    private Long menuPrice;

    @JsonIgnore // <- 필드에 추가하면 해당 필드는 JSON 직렬화/역직렬화 과정에서 무시(참조했기 때문에 조회 시 나오질 않음 = 외래키)
                // 직렬화 : 객체를 바이트 스트림 또는 문자열 등의 형태로 변환하는 과정
    @ManyToOne
    @JoinColumn(name = "corner_num")
    private FoodCorner cornerNum;

    @JsonIgnore
    @OneToMany(mappedBy = "menuNum", cascade = CascadeType.REMOVE)
    private List<FoodOrder> children;
}
