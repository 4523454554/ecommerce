package com.jay.ecommerce.category;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.NoSuchElementException;

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

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                ()-> new NoSuchElementException());
    }

    @Transactional
    public void updateById(Long id, CategoryDto categoryDto) {

        Category category = this.findById(id);

        category.updateCategory(categoryDto.getCategoryName(), categoryDto.getDescription(), categoryDto.getImageUrl());

        categoryRepository.save(category);

//        category.builder()
//                .id(category.getId())
//                .categoryName(categoryDto.getCategoryName())
//                .description(categoryDto.getDescription())
//                .imageUrl(categoryDto.getImageUrl())
//                .build();
    }

    public void deleteById(Long id, Yn yn) {
        Category category = this.findById(id);

        category.deleteCategory(yn);
    }
}
