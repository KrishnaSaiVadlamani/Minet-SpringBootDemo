package com.example.MinetDemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user_portfolio")
public class UserPortFolio {



    @Id
    @Column(name = "user_id")
    @Getter
    @Setter
    private int userId;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(
            name="user_portfolio_has_crypto",
            joinColumns=@JoinColumn(name="user_portfolio_id",referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name="crypto_id",referencedColumnName = "id")
    )
    @Getter @Setter
    private List<Crypto> cryptoList;

    public UserPortFolio() {
    }

    public UserPortFolio(int userId) {
        this.userId = userId;
    }
}
