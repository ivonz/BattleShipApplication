package com.example.battleshipapplication.repositories;

import com.example.battleshipapplication.Domain.entities.Ship;
import com.example.battleshipapplication.Domain.entities.User;
import com.example.battleshipapplication.Domain.model.ShipModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    Optional<Ship> findByName(String name);
    Optional<List<Ship>> findAllByUserId(Long id);
}
