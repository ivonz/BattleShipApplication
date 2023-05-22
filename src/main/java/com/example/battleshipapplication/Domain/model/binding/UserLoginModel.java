package com.example.battleshipapplication.Domain.model.binding;

import com.example.battleshipapplication.validations.checkUserExistence.ValidateLoginForm;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ValidateLoginForm
public class UserLoginModel {
    private String username;
    private String password;
}
