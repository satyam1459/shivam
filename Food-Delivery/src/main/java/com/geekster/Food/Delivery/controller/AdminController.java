package com.geekster.Food.Delivery.controller;

import com.geekster.Food.Delivery.model.FoodItem;
import com.geekster.Food.Delivery.model.FoodOrder;
import com.geekster.Food.Delivery.service.FoodItemService;
import com.geekster.Food.Delivery.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private FoodItemService foodItemService;

    @Autowired
    private FoodOrderService foodOrderService;

    @GetMapping("/fooditem")
    public List<FoodItem> getAllFoodItems() {
        return foodItemService.getAllFoodItems();
    }

    @GetMapping("/fooditem/{id}")
    public FoodItem getFoodItemById(@PathVariable Long id) {
        return foodItemService.getFoodItemById(id);
    }

    @PostMapping("/fooditem")
    public ResponseEntity<String> createFoodItem(@RequestBody FoodItem foodItem) {
        HttpStatus status;
        String msg = "";
        if(foodItemService.addFoodItem(foodItem)){
            msg ="Food item added";
            status = HttpStatus.ACCEPTED;
        }else{
            msg ="Invalid information";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg,status);
    }

    @DeleteMapping("/fooditem/{id}")
    public void deleteFoodItem(@PathVariable Long id) {
        foodItemService.deleteFoodItem(id);
    }

    @GetMapping("/orders")
    public List<FoodOrder> getAllOrders(){
        return foodOrderService.getAllOrders();
    }
}