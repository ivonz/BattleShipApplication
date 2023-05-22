package com.example.battleshipapplication.services;

import com.example.battleshipapplication.Domain.entities.User;
import com.example.battleshipapplication.Domain.helpers.LoggedUser;
import com.example.battleshipapplication.Domain.model.binding.UserLoginModel;
import com.example.battleshipapplication.Domain.model.binding.UserRegisterModel;
import com.example.battleshipapplication.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    @Autowired
    public AuthService(UserRepository userRepository, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    public void registerUser(UserRegisterModel userRegisterModel) {
        this.userRepository.saveAndFlush(this.modelMapper.map(userRegisterModel, User.class));
    }

    public void loginUser(UserLoginModel userLoginModel) {
        User byUsername = this.userRepository.findByUsername(userLoginModel.getUsername()).get();

        this.loggedUser.setId(byUsername.getId());
    }

    public void logoutUser() {
        loggedUser.clearUser();
    }
}
