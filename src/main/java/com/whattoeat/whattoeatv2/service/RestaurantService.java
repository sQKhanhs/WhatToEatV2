package com.whattoeat.whattoeatv2.service;

import com.whattoeat.whattoeatv2.dto.RestaurantDto;
import com.whattoeat.whattoeatv2.dto.ReviewDto;
import com.whattoeat.whattoeatv2.dto.UserDto;
import com.whattoeat.whattoeatv2.entity.Food;
import com.whattoeat.whattoeatv2.entity.Restaurant;
import com.whattoeat.whattoeatv2.entity.Review;
import com.whattoeat.whattoeatv2.entity.User;
import com.whattoeat.whattoeatv2.repository.IRestaurantRepository;
import com.whattoeat.whattoeatv2.repository.IReviewRepository;
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
public class RestaurantService implements IRestaurantService{

    private IRestaurantRepository restaurantRepository;
    private IReviewRepository reviewRepository;

    @Override
    public Page<Restaurant> findAll(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }

    @Override
    public Page<Restaurant> findAllById(Long id, Pageable pageable) {
        return restaurantRepository.findAllById(id, pageable);
    }


    @Override
    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void remove(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public long getRestaurantCount() {
        return restaurantRepository.count();
    }

    @Override
    public List<ReviewDto> findReview(Long id) {
        List<Review> reviews = reviewRepository.findAllByRestaurantId(id);
        return reviews.stream().map((review) -> convertReviewEntityToDto(review))
                .collect(Collectors.toList());
    }

    @Override
    public List<RestaurantDto> search(String name) {
        List<Restaurant> restaurants = restaurantRepository.search(name);
        return restaurants.stream().map((restaurant) -> convertRestaurantEntityToDto(restaurant))
                .collect(Collectors.toList());
    }

    private ReviewDto convertReviewEntityToDto(Review review){
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setRestaurant(review.getRestaurant());
        reviewDto.setId(review.getId());
        reviewDto.setUser(review.getUser());
        reviewDto.setUser_comment(review.getUser_comment());
        reviewDto.setScore(review.getScore());
        return reviewDto;
    }

    private RestaurantDto convertRestaurantEntityToDto(Restaurant restaurant){
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setId(restaurant.getId());
        restaurantDto.setName(restaurant.getName());
        restaurantDto.setImage(restaurant.getImage());
        restaurantDto.setAddress(restaurant.getAddress());
        restaurantDto.setReviews(restaurant.getReviews());
        restaurantDto.setOrderLink(restaurant.getOrderLink());
        restaurantDto.setRatingScore(restaurant.getRatingScore());
        restaurantDto.setTotalRating(restaurant.getTotalRating());
        restaurantDto.setRestaurantFoods(restaurant.getRestaurantFoods());
        return restaurantDto;
    }
}
