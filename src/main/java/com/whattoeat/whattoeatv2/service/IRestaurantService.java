package com.whattoeat.whattoeatv2.service;

import com.whattoeat.whattoeatv2.dto.FoodDto;
import com.whattoeat.whattoeatv2.dto.RestaurantDto;
import com.whattoeat.whattoeatv2.dto.ReviewDto;
import com.whattoeat.whattoeatv2.entity.Restaurant;
import com.whattoeat.whattoeatv2.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IRestaurantService {
    Page<Restaurant> findAll(Pageable pageable);

    Page<Restaurant> findAllById(Long id, Pageable pageable);

    Optional<Restaurant> findById(Long id);

    Restaurant save(Restaurant restaurant);

    void remove(Long id);

    long getRestaurantCount();

    List<ReviewDto> findReview(Long id);

    List<RestaurantDto> search(String name);
}
