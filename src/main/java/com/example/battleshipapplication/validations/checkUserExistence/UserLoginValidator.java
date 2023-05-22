package com.example.battleshipapplication.validations.checkUserExistence;

import com.example.battleshipapplication.Domain.model.UserModel;
import com.example.battleshipapplication.Domain.model.binding.UserLoginModel;
import com.example.battleshipapplication.Domain.model.binding.UserRegisterModel;
import com.example.battleshipapplication.services.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UserLoginValidator implements ConstraintValidator<ValidateLoginForm, UserLoginModel> {

    private final UserService userService;

    @Autowired
    public UserLoginValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void initialize(ValidateLoginForm constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(UserLoginModel userRegisterModel, ConstraintValidatorContext constraintValidatorContext) {
        UserModel user = this.userService.findByUsername(userRegisterModel.getUsername());

        return user.getId() != null
                && user.getPassword().equals(userRegisterModel.getPassword());
    }
}
