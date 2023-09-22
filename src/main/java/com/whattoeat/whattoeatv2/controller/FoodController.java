package com.whattoeat.whattoeatv2.controller;

import com.whattoeat.whattoeatv2.dto.FoodDto;
import com.whattoeat.whattoeatv2.entity.Food;
import com.whattoeat.whattoeatv2.service.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class FoodController {

    private FoodService foodService;

    @PostMapping("/add")
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        return new ResponseEntity<>(foodService.save(food), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<FoodDto>> searchFood(@RequestParam("search_name") String name) {
        return new ResponseEntity<>(foodService.search(name), HttpStatus.OK);
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<Food> editFood(@PathVariable Long id) {
        return new ResponseEntity<>(foodService.editFood(id), HttpStatus.OK);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food food){
        return new ResponseEntity<>(foodService.updateFood(id, food), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Food> deleteFood(@PathVariable Long id){
        foodService.deleteFood(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
