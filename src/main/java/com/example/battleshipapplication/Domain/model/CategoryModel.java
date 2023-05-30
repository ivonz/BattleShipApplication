package com.example.battleshipapplication.Domain.model;

import com.example.battleshipapplication.Domain.enums.CategoryType;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryModel {

    private Long id;
    private CategoryType name;
    private String description;
}
