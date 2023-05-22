package com.example.battleshipapplication.Domain.entities;

import com.example.battleshipapplication.Domain.enums.CategoryType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(unique = true)
    private CategoryType name;

    @Column(columnDefinition = "TEXT")
    private String description;
}
