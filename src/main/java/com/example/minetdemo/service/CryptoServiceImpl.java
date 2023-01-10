package com.example.minetdemo.service;

import com.example.minetdemo.dao.CryptoRepository;
import com.example.minetdemo.dto.CryptoDto;
import com.example.minetdemo.entity.Crypto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CryptoServiceImpl implements CryptoService{

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private CryptoRepository cryptoRepository;
    @Override
    public List<CryptoDto> findAllCryptos() {
        return cryptoRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Crypto findCryptoById(int theId) {
        Optional<Crypto> result = cryptoRepository.findById(theId);

        Crypto theCrypto = null;

        if (result.isPresent()) {
            theCrypto = result.get();
        }else{
            throw new RuntimeException();
        }

        return theCrypto;
    }

    @Override
    public Crypto saveCrypto(Crypto theCrypto) {
      return  cryptoRepository.save(theCrypto);
    }

    public CryptoDto convertEntityToDto(Crypto crypto) {
        return mapper.map(crypto, CryptoDto.class);
    }

}
