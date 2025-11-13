package com.example.AniMart.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "booking_items")
public class BookingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "toy_id", nullable = false)
    private Toy toy;

    private Integer quantity = 1;
    private BigDecimal price;

    public BookingItem() {}

    public BookingItem(Booking booking, Toy toy, Integer quantity, BigDecimal price) {
        this.booking = booking;
        this.toy = toy;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Booking getBooking() { return booking; }
    public void setBooking(Booking booking) { this.booking = booking; }
    public Toy getToy() { return toy; }
    public void setToy(Toy toy) { this.toy = toy; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}
