package com.whattoeat.whattoeatv2.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.whattoeat.whattoeatv2.entity.RestaurantFood;
import com.whattoeat.whattoeatv2.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDto {
    private Long id;
    private String name;
    @Column(length = 2000)
    private String description;
    private int calories;
    private String cuisine;
    private String image;
    private User user;
    private List<RestaurantFood> restaurantFoods;
}
