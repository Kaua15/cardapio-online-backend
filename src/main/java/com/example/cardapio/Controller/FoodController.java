package com.example.cardapio.Controller;

import com.example.cardapio.Model.Food;
import com.example.cardapio.Repository.FoodRepository;
import com.example.cardapio.Request.FoodRequestDTO;
import com.example.cardapio.Request.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponseDTO> getAll() {
        List<FoodResponseDTO> foodList = foodRepository.findAll().stream().map(food -> new FoodResponseDTO(food)).toList();
        return foodList;
    }

    @GetMapping("/{id}")
    public Optional<Food> getById(@PathVariable Long id) {
        Optional<Food> foodItem = foodRepository.findById(id);
        return foodItem;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequestDTO data) {
        Food foodData = new Food(data);
        foodRepository.save(foodData);
        return;
    }
}
