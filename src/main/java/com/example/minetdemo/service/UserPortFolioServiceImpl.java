package com.example.minetdemo.service;

import com.example.minetdemo.dao.UserPortFolioRepository;
import com.example.minetdemo.entity.UserPortFolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserPortFolioServiceImpl implements UserPortFolioService{

    @Autowired
    private UserPortFolioRepository userPortFolioRepository;

    @Override
    public UserPortFolio findPortFoliosByUserId(int id) {
        Optional<UserPortFolio> result =userPortFolioRepository.findById(id);
        UserPortFolio userPortFolio = null;

        if(result.isPresent()){
            userPortFolio=result.get();
        }else{
            throw new RuntimeException();
        }
        return userPortFolio;
    }

    @Override
    public UserPortFolio saveUserPortFolio(UserPortFolio userPortFolio) {
      return userPortFolioRepository.save(userPortFolio);
    }

    @Override
    public List<UserPortFolio> getPortFolioByUserId(int id) {
        return userPortFolioRepository.getUserPortFolioByUserId(id);
    }
}
