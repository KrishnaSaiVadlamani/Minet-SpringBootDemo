package com.example.minetdemo.dto;

import com.example.minetdemo.entity.UserPortFolio;
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
