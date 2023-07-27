package com.geekster.Food.Delivery.repository;

import com.geekster.Food.Delivery.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodItemRepo extends JpaRepository<FoodItem, Long> {
    FoodItem findByFoodItemId(Long foodItemId);
}
