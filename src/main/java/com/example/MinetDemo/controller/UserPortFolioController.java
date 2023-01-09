package com.example.MinetDemo.controller;

import com.example.MinetDemo.entity.UserPortFolio;
import com.example.MinetDemo.service.UserPortFolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class UserPortFolioController {

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
            System.out.println("Exception Occured!!! at adding UserPortFolio "+e);
        }
    }

}
