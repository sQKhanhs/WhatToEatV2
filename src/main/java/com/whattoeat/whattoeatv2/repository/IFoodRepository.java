package com.whattoeat.whattoeatv2.repository;

import com.whattoeat.whattoeatv2.dto.FoodDto;
import com.whattoeat.whattoeatv2.entity.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFoodRepository extends PagingAndSortingRepository<Food, Long>, CrudRepository<Food, Long> {
    @Query("SELECT f FROM Food f WHERE f.name LIKE %?1%")
    List<Food> search(String name);
}
