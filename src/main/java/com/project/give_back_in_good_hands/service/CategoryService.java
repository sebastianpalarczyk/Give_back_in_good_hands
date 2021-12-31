package com.project.give_back_in_good_hands.service;

import com.project.give_back_in_good_hands.domain.Category;
import com.project.give_back_in_good_hands.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> categories(){
        return categoryRepository.findAll();
    }
}
