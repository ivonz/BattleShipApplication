package com.example.battleshipapplication.validations.checkShipExistence;

import com.example.battleshipapplication.Domain.entities.Ship;
import com.example.battleshipapplication.repositories.ShipRepository;
import com.example.battleshipapplication.validations.checkUserExistence.ValidateLoginForm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ShipExistenceValidator implements ConstraintValidator<ValidateExistenceOfShip, String> {

    private final ShipRepository shipRepository;

    @Autowired
    public ShipExistenceValidator(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public void initialize(ValidateExistenceOfShip constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String shipName, ConstraintValidatorContext constraintValidatorContext) {
        return this.shipRepository.findByName(shipName).isEmpty();
    }
}
