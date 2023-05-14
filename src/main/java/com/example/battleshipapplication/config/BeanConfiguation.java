package com.example.battleshipapplication.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguation {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
