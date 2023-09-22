package com.whattoeat.whattoeatv2.repository;

import com.whattoeat.whattoeatv2.entity.RestaurantFood;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantFoodRepository extends PagingAndSortingRepository<RestaurantFood, Long>, CrudRepository<RestaurantFood, Long> {
    Page<RestaurantFood> findAllByFood_Id(Long id, Pageable pageable);
}
