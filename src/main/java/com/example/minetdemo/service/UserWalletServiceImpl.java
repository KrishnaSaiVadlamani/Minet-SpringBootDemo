package com.example.minetdemo.service;

import com.example.minetdemo.dao.UserWalletRepository;
import com.example.minetdemo.dto.UserWalletDto;
import com.example.minetdemo.entity.UserWallet;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserWalletServiceImpl implements UserWalletService{

    @Autowired
    private UserWalletRepository userWalletRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public UserWallet findById(int user_id) {
        Optional<UserWallet> result = userWalletRepository.findById(user_id);
        UserWallet userWallet = null;

        if(result.isPresent()){
            userWallet=result.get();
        }else{
            throw new RuntimeException();
        }
        return userWallet;
    }

    @Override
    public UserWallet savewallet(UserWallet userWallet) {
        return userWalletRepository.save(userWallet);
    }

    @Override
    public List<UserWalletDto> findAllWallets() {
        return userWalletRepository.findAll().stream().map(this::convertEntityToDTO)
                .toList();

    }

    public UserWalletDto convertEntityToDTO(UserWallet userWallet){
        return mapper.map(userWallet,UserWalletDto.class);
    }

}
