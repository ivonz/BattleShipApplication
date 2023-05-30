package com.example.battleshipapplication.repositories;

import com.example.battleshipapplication.Domain.entities.Category;
import com.example.battleshipapplication.Domain.enums.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryType categoryType);
}
