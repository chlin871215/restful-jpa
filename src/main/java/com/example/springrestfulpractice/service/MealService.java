package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.controller.dto.request.CreateMealRequest;
import com.example.springrestfulpractice.controller.dto.request.UpdateMealRequest;
import com.example.springrestfulpractice.model.MealRepository;
import com.example.springrestfulpractice.model.OrderRepository;
import com.example.springrestfulpractice.model.entity.Meal;
import com.example.springrestfulpractice.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private OrderRepository orderRepository;

    public List<Meal> getAllMeal() {
        List<Meal> meals = this.mealRepository.findAll();
        return meals;
    }

    public Meal getMealById(int id) {
        Meal meal = this.mealRepository.findById(id);
        return meal;
    }

    public String createMeal(CreateMealRequest request) {
        //錯誤檢查
        if (this.mealRepository.findById(request.getId()) != null) {
            return "Meal already exist";
        }
        Meal meal = new Meal();
        meal.setId(request.getId());
        meal.setName(request.getName());
        meal.setPrice(request.getPrice());
        meal.setDescription(request.getDescription());
        mealRepository.save(meal);
        return "OK";
    }

    public String updateMeal(int id, UpdateMealRequest request) {
        Meal meal = this.mealRepository.findById(id);
        //錯誤檢查
        if (meal == null) {
            return "Meal doesn't exist";
        }
        meal.setName(request.getName());
        meal.setPrice(request.getPrice());
        meal.setDescription(request.getDescription());
        mealRepository.save(meal);
        return "OK";
    }

    public String deleteMeal(int id) {
        if (this.mealRepository.findById(id) == null) {
            return "Meal doesn't exist";
        }
        for (Order order : this.orderRepository.findAll()) {
            for (Meal meal : order.getMealList()) {
                if (meal.getId() == id) {
                    return "Meal has been order";
                }
            }
        }
        this.mealRepository.deleteById(id);
        return "OK";
    }

}
