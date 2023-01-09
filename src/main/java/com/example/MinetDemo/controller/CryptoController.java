package com.example.MinetDemo.controller;

import com.example.MinetDemo.dto.CryptoDto;
import com.example.MinetDemo.entity.Crypto;
import com.example.MinetDemo.service.CryptoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class CryptoController {

    @Autowired
    private CryptoService cryptoService;


    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/crypto")
    public List<CryptoDto> getCryptos() {
        return cryptoService.findAllCryptos().stream().map(post -> modelMapper.map(post, CryptoDto.class))
                .collect(Collectors.toList());
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
            System.out.println("Exception Occured in crypto adding!!! " + e);
        }
    }
}