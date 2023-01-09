package com.example.MinetDemo.dao;

import com.example.MinetDemo.entity.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWallet,Integer> {
}
