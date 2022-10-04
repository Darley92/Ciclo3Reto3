package com.example.ciclo3_reto3.service;

import com.example.ciclo3_reto3.entities.Category;
import com.example.ciclo3_reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category save(Category c){
        if(c.getIdCategory()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> e = categoryRepository.getCategory(c.getIdCategory());
            if(e.isPresent()){
                return c;
            }else{
                return categoryRepository.save(c);
            }
        }
    }
    public Category update(Category c){
        if(c.getIdCategory()!=null){
            Optional<Category> f = categoryRepository.getCategory(c.getIdCategory());
            if(f.isPresent()){
                if(c.getName()!=null){
                    f.get().setName(c.getName());
                }
                categoryRepository.save(f.get());
                return f.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Category>p= categoryRepository.getCategory(id);
        if(p.isPresent()){
            categoryRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }
}
