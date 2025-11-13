package com.example.AniMart.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    @ManyToOne
    @JoinColumn(name = "toy_id")
    private Toy toy;

    private int quantity = 1;

    private LocalDateTime addedAt = LocalDateTime.now();

    public Cart() {}
    public Cart(Integer userId, Toy toy) {
        this.userId = userId;
        this.toy = toy;
    }

    public Integer getId() { return id; }
    public Integer getUserId() { return userId; }
    public Toy getToy() { return toy; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
