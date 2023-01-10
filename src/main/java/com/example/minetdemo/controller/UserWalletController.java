package com.example.minetdemo.controller;

import com.example.minetdemo.dto.UserWalletDto;
import com.example.minetdemo.entity.UserWallet;
import com.example.minetdemo.service.UserWalletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/")
public class UserWalletController {

    Logger logger
            = LoggerFactory.getLogger(UserWalletController.class);

    @Autowired
    private UserWalletService userWalletService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/wallet/{id}")
    public UserWallet getUserWalletById(@PathVariable int id){
        return userWalletService.findById(id);
    }

    @GetMapping("/wallet")
    public List<UserWalletDto> userWalletDtoList(){
        return userWalletService.findAllWallets().stream().map(post -> modelMapper.map(post, UserWalletDto.class)).toList();
    }
    @PostMapping("/wallet")
    public void addWallet(@RequestBody UserWallet userWallet){
        try{
            userWalletService.savewallet(userWallet);
        }catch (Exception e){
            logger.error("Exception occured!!! at adding wallet ");
        }
    }

}
