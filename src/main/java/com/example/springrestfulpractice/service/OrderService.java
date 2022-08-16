package com.example.springrestfulpractice.service;

import com.example.springrestfulpractice.controller.dto.request.CreateOrderRequest;
import com.example.springrestfulpractice.controller.dto.request.UpdateOrderRequest;
import com.example.springrestfulpractice.model.MealRepository;
import com.example.springrestfulpractice.model.OrderRepository;
import com.example.springrestfulpractice.model.entity.Meal;
import com.example.springrestfulpractice.model.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MealRepository mealRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrder(int seq) {
        return orderRepository.findBySeq(seq);
    }

    public String createOrder(CreateOrderRequest createOrderRequest) {
        Order order = new Order();
        //check
        if (orderRepository.findBySeq(createOrderRequest.getSeq()) != null) {
            return "Order already exist";
        }
        //check twice meal
        for (Meal meal1 : createOrderRequest.getMealList()) {
            int count = 0;
            for (Meal meal2 : createOrderRequest.getMealList()) {
                if (meal1.getId() == meal2.getId()) {
                    count++;
                }
                if (count > 1) {
                    return "Create same meal in order";
                }
            }
        }
        //check mealList
        for (Meal meal : createOrderRequest.getMealList()) {
            if (mealRepository.findById(meal.getId()) == null) {
                return "Wrong meal id";
            } else if (!mealRepository.findById(meal.getId()).getName().equals(meal.getName())) {
                return "Wrong meal name";
            } else if (mealRepository.findById(meal.getId()).getPrice() != meal.getPrice()) {
                return "Wrong meal price";
            } else if (!mealRepository.findById(meal.getId()).getDescription().equals(meal.getDescription())) {
                return "Wrong meal description";
            }
        }
        //儲存
        order.setSeq(createOrderRequest.getSeq());
        order.setWaiter(createOrderRequest.getWaiter());
        order.setTotalPrice(createOrderRequest.getTotalPrice());
        order.setMealList(createOrderRequest.getMealList());
        orderRepository.save(order);
        return "OK";
    }

    public String updateOrder(int seq, UpdateOrderRequest updateOrderRequest) {
        Order order = orderRepository.findBySeq(seq);
        //check
        if (order == null) {
            return "Order doesn't exist";
        }
        //check mealList
        for (Meal meal : updateOrderRequest.getMealList()) {
            if (mealRepository.findById(meal.getId()) == null) {
                return "Wrong meal id";
            } else if (!mealRepository.findById(meal.getId()).getName().equals(meal.getName())) {
                return "Wrong meal name";
            } else if (mealRepository.findById(meal.getId()).getPrice() != meal.getPrice()) {
                return "Wrong meal price";
            } else if (!mealRepository.findById(meal.getId()).getDescription().equals(meal.getDescription())) {
                return "Wrong meal description";
            }
        }
        //check twice meal
        for (Meal meal1 : updateOrderRequest.getMealList()) {
            int count = 0;
            for (Meal meal2 : updateOrderRequest.getMealList()) {
                if (meal1.getId() == meal2.getId()) {
                    count++;
                }
                if (count > 1) {
                    return "Create same meal in order";
                }
            }
        }
        //儲存
        order.setTotalPrice(updateOrderRequest.getTotalPrice());
        order.setWaiter(updateOrderRequest.getWaiter());
        order.setMealList(updateOrderRequest.getMealList());
        orderRepository.save(order);
        return "OK";
    }

    public String deleteOrderBySeq(int seq) {
        Order order = orderRepository.findBySeq(seq);
        //check
        if (null == order) {
            return "Order doesn't exist";
        }
        //先刪除order_meal，因為這張表有關連到order
        orderRepository.deleteOrderMealBySeq(seq);
        //再刪除order
        orderRepository.deleteOrderBySeq(seq);
        return "OK";
    }

}
