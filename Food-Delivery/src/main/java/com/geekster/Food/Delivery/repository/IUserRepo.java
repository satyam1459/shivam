package com.geekster.Food.Delivery.repository;

import com.geekster.Food.Delivery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User,Long> {

    User findFirstByUserEmail(String userEmail);

    User findByUserId(Long userId);
}
