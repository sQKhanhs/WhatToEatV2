package com.whattoeat.whattoeatv2.service;

import com.whattoeat.whattoeatv2.entity.RestaurantFood;
import com.whattoeat.whattoeatv2.repository.IRestaurantFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantFoodService implements IRestaurantFoodService{
    @Autowired
    private IRestaurantFoodRepository restaurantFoodRepository;

    @Override
    public Page<RestaurantFood> findAll(Pageable pageable) {
        return restaurantFoodRepository.findAll(pageable);
    }

    @Override
    public Page<RestaurantFood> findAllByFood_Id(Long id, Pageable pageable) {
        return restaurantFoodRepository.findAllByFood_Id(id, pageable);
    }

    @Override
    public Optional<RestaurantFood> findById(Long id) {
        return restaurantFoodRepository.findById(id);
    }

    @Override
    public RestaurantFood save(RestaurantFood restaurantFood) {
        return restaurantFoodRepository.save(restaurantFood);
    }

    @Override
    public void remove(Long id) {
        restaurantFoodRepository.deleteById(id);
    }


}
