package com.example.minetdemo.dto;

import lombok.Data;

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
