package com.example.springrestfulpractice.controller;

import com.example.springrestfulpractice.controller.dto.request.CreateMealRequest;
import com.example.springrestfulpractice.controller.dto.request.UpdateMealRequest;
import com.example.springrestfulpractice.controller.dto.response.StatusResponse;
import com.example.springrestfulpractice.model.entity.Meal;
import com.example.springrestfulpractice.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {
    @Autowired
    private MealService mealService;

    @GetMapping
    public List<Meal> getAllMeals() {
        List<Meal> meals = this.mealService.getAllMeal();
        return meals;
    }

    @GetMapping("/{id}")
    public Meal getMealById(@PathVariable int id) {
        Meal meal = this.mealService.getMealById(id);
        return meal;
    }

    @PostMapping
    public StatusResponse createMeal(@RequestBody CreateMealRequest createMealRequest) {
        String response = this.mealService.createMeal(createMealRequest);
        return new StatusResponse(response);
    }

    @PutMapping("/{id}")
    public StatusResponse updateMeal(@PathVariable int id, @RequestBody UpdateMealRequest updateMealRequest) {
        String response = this.mealService.updateMeal(id, updateMealRequest);
        return new StatusResponse(response);
    }

    @DeleteMapping("/{id}")
    public StatusResponse deleteMeal(@PathVariable int id) {
        String response = this.mealService.deleteMeal(id);
        return new StatusResponse(response);
    }


}
