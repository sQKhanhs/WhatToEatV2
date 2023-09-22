package com.whattoeat.whattoeatv2.repository;

import com.whattoeat.whattoeatv2.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findAllByRestaurantId(Long id);
}
