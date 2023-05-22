package com.example.battleshipapplication.Domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserModel {

    private Long id;
    private String username;
    private String fullName;
    private String password;
    private String email;

}
