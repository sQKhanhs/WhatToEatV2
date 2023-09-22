package com.whattoeat.whattoeatv2.controller;

import com.whattoeat.whattoeatv2.dto.RestaurantDto;
import com.whattoeat.whattoeatv2.dto.ReviewDto;
import com.whattoeat.whattoeatv2.service.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api_restaurant")
public class RestaurantController {
    private RestaurantService restaurantService;

    @GetMapping("/findReview/{id}")
    public ResponseEntity<List<ReviewDto>> findReview(@PathVariable Long id) {
        return new ResponseEntity<>(restaurantService.findReview(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<RestaurantDto>> searchFood(@RequestParam("search_name") String name) {
        return new ResponseEntity<>(restaurantService.search(name), HttpStatus.OK);
    }
}
