package com.example.minetdemo.controller;

import com.example.minetdemo.entity.UserPortFolio;
import com.example.minetdemo.service.UserPortFolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/")
public class UserPortFolioController {

    Logger logger
            = LoggerFactory.getLogger(UserPortFolioController.class);

    @Autowired
    private UserPortFolioService userPortFolioService;

    @GetMapping("/userportfolio/{id}")
    public List<UserPortFolio> getUserPortFolioById(@PathVariable int id){
        return userPortFolioService.getPortFolioByUserId(id);
    }

    @PostMapping("/userportfolio")
    public void addUserPortFolio(@RequestBody UserPortFolio userPortFolio){
        try{
            userPortFolioService.saveUserPortFolio(userPortFolio);
        }catch(Exception e){
            logger.error("Exception Occured!!! at adding UserPortFolio ");
        }
    }

}
