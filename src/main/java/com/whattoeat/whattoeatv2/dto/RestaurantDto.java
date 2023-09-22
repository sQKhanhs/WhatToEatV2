package com.whattoeat.whattoeatv2.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.whattoeat.whattoeatv2.entity.RestaurantFood;
import com.whattoeat.whattoeatv2.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    private Long id;
    private String name;
    private String address;
    private String image;
    private String orderLink;
    private int ratingScore;
    private int totalRating;

    private List<RestaurantFood> restaurantFoods;

    private List<Review> reviews;
}
