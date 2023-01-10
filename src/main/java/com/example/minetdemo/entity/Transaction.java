package com.example.minetdemo.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;
    @Column(name = "transaction_type")
    @Getter
    @Setter
    private String type;
    @Column(name = "wallet_amount")
    @Getter
    @Setter
    private double walletAmount;
    @Column(name = "transaction_amount")
    @Getter
    @Setter
    private double transactionAmount;
    @Column(name = "user_id")
    @Getter
    @Setter
    private int userId;
    @Column(name = "updated_at")
    @Getter
    @Setter
    private LocalDateTime updatedAt;
    @Column(name = "user_wallet_id")
    @Getter
    @Setter
    private int userWalletId;

    @Column(name = "crypto_id")
    @Getter @Setter
    private int cryptoId;


    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "user_wallet_id")
    private UserWallet userWallet;

    public Transaction(String type, double walletAmount, double transactionAmount, int userId, LocalDateTime updatedAt, int userWalletId,int cryptoId) {
        this.type = type;
        this.walletAmount = walletAmount;
        this.transactionAmount = transactionAmount;
        this.userId = userId;
        this.updatedAt = updatedAt;
        this.userWalletId = userWalletId;
        this.cryptoId=cryptoId;
    }

    public Transaction() {
    }
}
