package com.geekster.Food.Delivery.repository;

import com.geekster.Food.Delivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<User, Long> {
}
