package com.geekster.Food.Delivery.repository;

import com.geekster.Food.Delivery.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthToken, Long> {
    AuthToken findFirstByToken(String token);
}
