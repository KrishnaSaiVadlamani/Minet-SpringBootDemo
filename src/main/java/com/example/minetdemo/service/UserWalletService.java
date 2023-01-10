package com.example.minetdemo.service;

import com.example.minetdemo.dto.UserWalletDto;
import com.example.minetdemo.entity.UserWallet;

import java.util.List;

public interface UserWalletService {
    UserWallet findById(int user_id);

    UserWallet savewallet(UserWallet userWallet);

    List<UserWalletDto> findAllWallets();
}
