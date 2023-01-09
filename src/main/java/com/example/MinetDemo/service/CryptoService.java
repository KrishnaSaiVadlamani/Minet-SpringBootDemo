package com.example.MinetDemo.service;

import com.example.MinetDemo.dto.CryptoDto;
import com.example.MinetDemo.entity.Crypto;

import java.util.List;

public interface CryptoService {
    List<CryptoDto> findAllCryptos();

    Crypto findCryptoById(int theId);

    Crypto saveCrypto(Crypto theCrypto);


}
