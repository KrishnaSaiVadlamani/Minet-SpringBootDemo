package com.example.MinetDemo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDto {

    private int id;
    private String type;
    private double walletAmount;
    private double transactionAmount;

    private int userId;

    private int cryptoId;

    private LocalDateTime updatedAt;

    private int walletId;
}
