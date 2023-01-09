package com.example.MinetDemo.service;

import com.example.MinetDemo.dto.UserWalletDto;
import com.example.MinetDemo.entity.UserWallet;

import java.util.List;

public interface UserWalletService {
    UserWallet findById(int user_id);

    UserWallet savewallet(UserWallet userWallet);

    List<UserWalletDto> findAllWallets();
}
