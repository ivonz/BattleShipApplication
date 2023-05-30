package com.example.battleshipapplication.Domain.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShipModel {
    private Long id;
    private String name;
    private Long health;
    private Long power;
    private Date created;
    private CategoryModel category;
    private UserModel user;
}
