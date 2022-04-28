package com.jay.ecommerce.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/create")
    public void createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        categoryService.createCategory(categoryDto);
    }

    @GetMapping("/list")
    public List<Category> showAllCategory() {
        return categoryService.showAllCategory();
    }

    @GetMapping("/{id}")
    public Category showOneCategory(Long id) {
        return categoryService.findById(id);
    }

    @PostMapping("/update/{id}")
    public void updateCategory(@PathVariable("id") Long id,
                                 @RequestBody CategoryDto categoryDto) {
        categoryService.updateById(id, categoryDto);
    }

    @PostMapping("/delete/{id}")
    public void deleteCategory(@PathVariable Long id,
                               @RequestParam Yn yn) {
        categoryService.deleteById(id, yn);
    }
}
