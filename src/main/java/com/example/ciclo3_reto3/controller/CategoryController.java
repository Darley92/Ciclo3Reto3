package com.example.ciclo3_reto3.controller;

import com.example.ciclo3_reto3.entities.Category;
import com.example.ciclo3_reto3.entities.Machine;
import com.example.ciclo3_reto3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();

    }
    @PostMapping("/save")
    public Category save(@RequestBody Category c){
        return categoryService.save(c);
    }

}
