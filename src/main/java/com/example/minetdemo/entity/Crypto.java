package com.example.minetdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "crypto")
public class Crypto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private int id;

    @Column(name = "crypto_name")
    @Getter
    @Setter
    private String cryptoName;

    @Column(name = "current_value")
    @Getter
    @Setter
    private double currentValue;

    @Column(name = "market_cap")
    @Getter
    @Setter
    private double marketCap;

    @Column(name = "vol_24h")
    @Getter
    @Setter
    private double vol24h;

    @Column(name = "circulating_supply")
    @Getter
    @Setter
    private double circulatingSupply;

    @Column(name = "percentage_change")
    @Getter @Setter
    private double percentageChange;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "crypto_id",referencedColumnName = "id")
    private List<WatchList> watchListList;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "crypto_id",referencedColumnName = "id")

    private List<Transaction> transactionList;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="user_portfolio_has_crypto",
            joinColumns=@JoinColumn(name="crypto_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="user_portfolio_user_id",referencedColumnName = "user_id")
    )
    private List<UserPortFolio> userPortFolioList;




    public Crypto() {
    }

    public Crypto(int id, String cryptoName, double currentValue, double marketCap, double vol24h, double circulatingSupply, double percentageChange) {
        this.id = id;
        this.cryptoName = cryptoName;
        this.currentValue = currentValue;
        this.marketCap = marketCap;
        this.vol24h = vol24h;
        this.circulatingSupply = circulatingSupply;
        this.percentageChange = percentageChange;
    }
}
