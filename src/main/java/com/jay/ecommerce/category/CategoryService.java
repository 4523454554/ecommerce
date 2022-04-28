package com.jay.ecommerce.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void createCategory(CategoryDto categoryDto) {
        categoryRepository.save(categoryDto.toEntity());
    }

    @Transactional(readOnly = false)
    public List<Category> showAllCategory() {
        return categoryRepository.findAll();
    }
}
