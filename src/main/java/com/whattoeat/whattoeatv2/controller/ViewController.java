package com.whattoeat.whattoeatv2.controller;

import com.whattoeat.whattoeatv2.entity.Food;
import com.whattoeat.whattoeatv2.entity.Restaurant;
import com.whattoeat.whattoeatv2.entity.RestaurantFood;
import com.whattoeat.whattoeatv2.entity.User;
import com.whattoeat.whattoeatv2.service.IFoodService;
import com.whattoeat.whattoeatv2.service.IRestaurantFoodService;
import com.whattoeat.whattoeatv2.service.IRestaurantService;
import com.whattoeat.whattoeatv2.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@AllArgsConstructor
@RequestMapping
public class ViewController {

    private IFoodService foodService;

    private IUserService userService;

    private IRestaurantService restaurantService;

    private IRestaurantFoodService restaurantFoodService;

    @ModelAttribute("user")
    public User addLoginUser(){
        return userService.findByLoginEmail();
    }

    @GetMapping("home")
    public ModelAndView homeView(@ModelAttribute("user")User user){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @GetMapping("about")
    public ModelAndView aboutView(@ModelAttribute("user")User user){
        ModelAndView modelAndView = new ModelAndView("about");
        modelAndView.addObject("foodCount", foodService.getFoodCount());
        modelAndView.addObject("restaurantCount", restaurantService.getRestaurantCount());
        return modelAndView;
    }

    @GetMapping("wiki")
    public ModelAndView wikiView(@PageableDefault(value = 4) Pageable pageable, @ModelAttribute("user")User user){
        Page<Food> foodList = foodService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("wiki");
        modelAndView.addObject("foodList", foodList);
        return modelAndView;
    }

    @GetMapping("restaurant")
    public ModelAndView restaurantView(@PageableDefault(value = 4) Pageable pageable, @ModelAttribute("user")User user){
        Page<Restaurant> restaurantList = restaurantService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("restaurant");
        modelAndView.addObject("restaurantList", restaurantList);
        return modelAndView;
    }

    @GetMapping("restaurant/{id}")
    public ModelAndView findRestaurantView(@PathVariable Long id, @PageableDefault(value = 4) Pageable pageable, @ModelAttribute("user")User user){
        Page<RestaurantFood> restaurantFoodList = restaurantFoodService.findAllByFood_Id(id, pageable);
        ModelAndView modelAndView = new ModelAndView("restaurantFind");
        modelAndView.addObject("restaurantList", restaurantFoodList);
        return modelAndView;
    }
}
