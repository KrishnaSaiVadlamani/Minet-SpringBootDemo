package com.example.minetdemo.service;

import com.example.minetdemo.dto.CryptoDto;
import com.example.minetdemo.entity.Crypto;

import java.util.List;

public interface CryptoService {
    List<CryptoDto> findAllCryptos();

    Crypto findCryptoById(int theId);

    Crypto saveCrypto(Crypto theCrypto);


}
