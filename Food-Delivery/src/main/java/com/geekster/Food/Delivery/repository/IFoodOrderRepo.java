package com.geekster.Food.Delivery.repository;

import com.geekster.Food.Delivery.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFoodOrderRepo extends JpaRepository<FoodOrder,Long> {
        FoodOrder findByFoodOrderId(Long orderId);
}
