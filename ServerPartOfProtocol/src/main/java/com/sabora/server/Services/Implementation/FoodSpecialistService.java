package com.sabora.server.Services.Implementation;

import com.sabora.server.Models.FoodSpecialist;
import com.sabora.server.Repositories.FoodSpecialistRepository;
import com.sabora.server.Services.UserService;

import java.util.List;


public class FoodSpecialistService implements UserService<FoodSpecialist> {

    private FoodSpecialistRepository foodSpecialistRepository;

    public FoodSpecialistService(FoodSpecialistRepository foodSpecialistRepository){
        this.foodSpecialistRepository = foodSpecialistRepository;
    }

    @Override
    public void registerUser(FoodSpecialist user) {
        foodSpecialistRepository.save(user);
    }

    @Override
    public FoodSpecialist getUser(String username) {
        List<FoodSpecialist> users = foodSpecialistRepository.findAll();
        for (FoodSpecialist user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

}
