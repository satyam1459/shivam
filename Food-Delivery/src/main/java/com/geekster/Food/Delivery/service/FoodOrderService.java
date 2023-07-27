package com.geekster.Food.Delivery.service;

import com.geekster.Food.Delivery.model.FoodItem;
import com.geekster.Food.Delivery.model.FoodOrder;
import com.geekster.Food.Delivery.model.User;
import com.geekster.Food.Delivery.repository.IFoodItemRepo;
import com.geekster.Food.Delivery.repository.IFoodOrderRepo;
import com.geekster.Food.Delivery.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodOrderService {
    @Autowired
    IFoodOrderRepo iFoodOrderRepository;

    @Autowired
    IUserRepo iUserRepository;

    @Autowired
    IFoodItemRepo foodItemRepository;

    public FoodOrder createOrder(FoodOrder foodOrder) {

        User user = iUserRepository.findByUserId(foodOrder.getUser().getUserId());
        foodOrder.setUser(user);
        FoodItem foodItem = foodItemRepository.findByFoodItemId(foodOrder.getFoodItem().getFoodItemId());
        foodOrder.setFoodItem(foodItem);

        return iFoodOrderRepository.save(foodOrder);
    }

    public FoodOrder getOrderById(Long orderId) {
        return iFoodOrderRepository.findByFoodOrderId(orderId);
    }

    public List<FoodOrder> getAllOrders() {
        return iFoodOrderRepository.findAll();
    }
}