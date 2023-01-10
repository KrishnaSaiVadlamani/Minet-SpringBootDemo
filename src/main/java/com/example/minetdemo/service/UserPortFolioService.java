package com.example.minetdemo.service;

import com.example.minetdemo.entity.UserPortFolio;

import java.util.List;

public interface UserPortFolioService {
    UserPortFolio findPortFoliosByUserId(int id);

    UserPortFolio saveUserPortFolio(UserPortFolio userPortFolio);

    List<UserPortFolio> getPortFolioByUserId(int id);
}
