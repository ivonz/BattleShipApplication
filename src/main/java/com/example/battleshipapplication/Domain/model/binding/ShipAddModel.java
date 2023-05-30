package com.example.battleshipapplication.Domain.model.binding;

import com.example.battleshipapplication.Domain.enums.CategoryType;
import com.example.battleshipapplication.validations.checkShipExistence.ValidateExistenceOfShip;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipAddModel {

    @Size(min = 2, max = 10)
    @NotNull
    @ValidateExistenceOfShip
    private String name;

    @Positive
    @NotNull
    private Long health;

    @NotNull
    private Long power;

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created;

    @NotNull
    private CategoryType category;

}
