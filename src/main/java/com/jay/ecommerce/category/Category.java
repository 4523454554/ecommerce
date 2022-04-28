package com.jay.ecommerce.category;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter()
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Builder
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "category_name")
    private String categoryName;

    @NotBlank
    private String description;

    @NotBlank
    @Column(name = "image_url")
    private String imageUrl;
}
