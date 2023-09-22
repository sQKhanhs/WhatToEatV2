package com.whattoeat.whattoeatv2.service;

import com.whattoeat.whattoeatv2.entity.RestaurantFood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IRestaurantFoodService {
    Page<RestaurantFood> findAll(Pageable pageable);

    Page<RestaurantFood> findAllByFood_Id(Long id, Pageable pageable);

    Optional<RestaurantFood> findById(Long id);

    RestaurantFood save(RestaurantFood restaurantFood);

    void remove(Long id);
}
