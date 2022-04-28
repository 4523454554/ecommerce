package com.jay.ecommerce.category;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {

//    private Long id;

    @NotBlank
    private String categoryName;

    @NotBlank
    private String description;

    @NotBlank
    private String imageUrl;

    public Category toEntity() {
        return Category.builder()
                .categoryName(categoryName)
                .description(description)
                .imageUrl(imageUrl)
                .build();
    }
}
