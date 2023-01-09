package com.example.MinetDemo.dto;

import com.example.MinetDemo.entity.Transaction;
import lombok.Data;

import java.util.List;
@Data
public class CryptoDto {

    private int id;

    private String cryptoName;

    private double currentValue;

    private double marketCap;

    private double vol24h;

    private double circulatingSupply;
    private double percentageChange;


}
