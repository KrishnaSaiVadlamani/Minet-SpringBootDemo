package com.example.MinetDemo.controller;

import com.example.MinetDemo.dto.TransactionDto;
import com.example.MinetDemo.dto.UserWalletDto;
import com.example.MinetDemo.entity.UserWallet;
import com.example.MinetDemo.service.UserWalletService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/")
public class UserWalletController {

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
        return userWalletService.findAllWallets().stream().map(post -> modelMapper.map(post, UserWalletDto.class)).collect(Collectors.toList());
    }
    @PostMapping("/wallet")
    public void addWallet(@RequestBody UserWallet userWallet){
        try{
            userWalletService.savewallet(userWallet);
        }catch (Exception e){
            System.out.println("Exception occured!!! at adding wallet "+e);
        }
    }

}
