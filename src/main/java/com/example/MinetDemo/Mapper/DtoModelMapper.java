package com.example.MinetDemo.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

    @Component
    public class DtoModelMapper {
        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }