package com.sabora.server.Controllers;

import com.sabora.server.DTOs.FoodDTO;
import com.sabora.server.Mappers.FoodMapper;
import com.sabora.server.Models.Food;
import com.sabora.server.Services.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@RestController
@RequestMapping("/food")
public class FoodController {

    private final FoodService foodService;
    private final FoodMapper foodMapper;

    public FoodController(FoodService foodService, FoodMapper foodMapper) {
        this.foodService = foodService;
        this.foodMapper = foodMapper;
    }

    @GetMapping("")
    public ResponseEntity<?> getFood(@RequestParam(name = "name") String name){
        return ResponseEntity.ok(foodService.getFood(name));
    }

    @GetMapping("s")
    public ResponseEntity<?> getAllFoods(){
        return ResponseEntity.ok(foodService.getAllFoods());
    }

    @PostMapping("")
    public ResponseEntity<?> postFood(@RequestBody  FoodDTO foodDTO){
        Food food = foodMapper.toEntity(foodDTO);
        foodService.addFood(food);
        return new ResponseEntity<>("Food added successfully", HttpStatus.CREATED);
    }
}
