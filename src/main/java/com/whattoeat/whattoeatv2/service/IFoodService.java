package com.whattoeat.whattoeatv2.service;

import com.whattoeat.whattoeatv2.dto.FoodDto;
import com.whattoeat.whattoeatv2.dto.UserDto;
import com.whattoeat.whattoeatv2.entity.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFoodService {
    Page<Food> findAll(Pageable pageable);

    List<FoodDto> search(String name);
    Optional<Food> findById(Long id);

    Food save(Food food);

    void remove(Long id);

    Food editFood(Long id);

    Food updateFood(Long id, Food food);

    long getFoodCount();

    void deleteFood(Long id);
}
