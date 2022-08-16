package com.example.springrestfulpractice.controller.dto.request;

import com.example.springrestfulpractice.model.entity.Meal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderRequest {

    private String waiter;
    private List<Meal> mealList;

    public int getTotalPrice() {
        int totalPrice=0;
        for (Meal meal : mealList) {
            totalPrice += meal.getPrice();
        }
        return totalPrice ;
    }
}
