package com.example.MinetDemo.dto;

import com.example.MinetDemo.entity.UserPortFolio;
import lombok.Data;


@Data
public class UserDto {

    private int id;
    private String firstName;

    private String lastName;
    private String email;
    private String password;

    private int walletId;

    private UserPortFolio userPortFolio;
}
