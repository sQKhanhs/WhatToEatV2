package com.whattoeat.whattoeatv2.service;

import com.whattoeat.whattoeatv2.dto.FoodDto;
import com.whattoeat.whattoeatv2.dto.UserDto;
import com.whattoeat.whattoeatv2.entity.Food;
import com.whattoeat.whattoeatv2.entity.User;
import com.whattoeat.whattoeatv2.repository.IFoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodService implements IFoodService {
    private IFoodRepository foodRepository;


    @Override
    public Page<Food> findAll(Pageable pageable) {
        return foodRepository.findAll(pageable);
    }

    @Override
    public List<FoodDto> search(String name) {
        List<Food> foods = foodRepository.search(name);
        return foods.stream().map((food) -> convertEntityToDto(food))
                .collect(Collectors.toList());
    }

    private FoodDto convertEntityToDto(Food food){
        FoodDto foodDto = new FoodDto();
        foodDto.setName(food.getName());
        foodDto.setId(food.getId());
        foodDto.setCalories(food.getCalories());
        foodDto.setImage(food.getImage());
        foodDto.setCuisine(food.getCuisine());
        foodDto.setDescription(food.getDescription());
        foodDto.setUser(food.getUser());
        foodDto.setRestaurantFoods(food.getRestaurantFoods());
        return foodDto;
    }

    @Override
    public Optional<Food> findById(Long id) {
        return foodRepository.findById(id);
    }

    @Override
    public Food save(Food food) {
        return foodRepository.save(food);
    }

    @Override
    public void remove(Long id) {
        foodRepository.deleteById(id);
    }

    @Override
    public Food editFood(Long id) {
        Optional<Food> food = foodRepository.findById(id);
        if(food.isPresent()){
            return food.get();
        } else {
            return null;
        }
    }

    @Override
    public Food updateFood(Long id, Food food) {
        food.setId(id);
        return foodRepository.save(food);
    }

    @Override
    public long getFoodCount() {
        return foodRepository.count();
    }

    @Override
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}
