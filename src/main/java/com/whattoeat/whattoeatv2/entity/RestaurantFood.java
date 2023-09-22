package com.whattoeat.whattoeatv2.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurantFood")
public class RestaurantFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "food_id")
    @JsonBackReference(value = "restaurants_foods1")
    private Food food;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @JsonBackReference(value = "restaurants_foods2")
    private Restaurant restaurant;
}
