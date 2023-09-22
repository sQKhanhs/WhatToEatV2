package com.whattoeat.whattoeatv2.repository;

import com.whattoeat.whattoeatv2.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRestaurantRepository extends PagingAndSortingRepository<Restaurant, Long>, CrudRepository<Restaurant, Long> {
    Page<Restaurant> findAllById(Long id, Pageable pageable);

    @Query("SELECT f FROM Restaurant f WHERE f.name LIKE %?1%")
    List<Restaurant> search(String name);
}
