package com.example.minetdemo.dao;

import com.example.minetdemo.entity.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWallet,Integer> {
}
