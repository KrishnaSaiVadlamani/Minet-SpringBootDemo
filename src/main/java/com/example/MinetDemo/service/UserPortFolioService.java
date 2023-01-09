package com.example.MinetDemo.service;

import com.example.MinetDemo.entity.User;
import com.example.MinetDemo.entity.UserPortFolio;

import java.util.List;

public interface UserPortFolioService {
    UserPortFolio findPortFoliosByUserId(int id);

    UserPortFolio saveUserPortFolio(UserPortFolio userPortFolio);

    List<UserPortFolio> getPortFolioByUserId(int id);
}
