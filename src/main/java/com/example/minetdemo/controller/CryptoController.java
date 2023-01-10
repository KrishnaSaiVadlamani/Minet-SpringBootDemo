package com.example.minetdemo.controller;

import com.example.minetdemo.dto.CryptoDto;
import com.example.minetdemo.entity.Crypto;
import com.example.minetdemo.service.CryptoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/")
public class CryptoController {

    Logger logger
            = LoggerFactory.getLogger(CryptoController.class);
    @Autowired
    private CryptoService cryptoService;


    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/crypto")
    public List<CryptoDto> getCryptos() {
        return cryptoService.findAllCryptos().stream().map(post -> modelMapper.map(post, CryptoDto.class)).toList();
    }
    @GetMapping("/crypto/{id}")
    public Crypto showCryptoById(@PathVariable int id) {
        return cryptoService.findCryptoById(id);
    }

    @PostMapping("/crypto")
    public void addCrypto(@RequestBody Crypto crypto) {
        try {
            cryptoService.saveCrypto(crypto);
        } catch (Exception e) {
            logger.error("Exception Occured in crypto adding!!! ");
        }
    }
}