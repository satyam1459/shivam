package com.geekster.Food.Delivery.service;

import com.geekster.Food.Delivery.model.AuthToken;
import com.geekster.Food.Delivery.repository.IAuthTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    IAuthTokenRepo tokenRepo;

    public void saveToken(AuthToken token) {
        tokenRepo.save(token);
    }

    public boolean authenticate(String email, String token) {
        if(token==null || email==null){
            return false;
        }

        AuthToken authToken = tokenRepo.findFirstByToken(token);

        if(authToken==null){
            return false;
        }

        String expectedEmail = authToken.getUser().getUserEmail();

        return expectedEmail.equals(email);
    }
}
