package com.example.AniMart.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDateTime bookingDate = LocalDateTime.now();

    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private BookingStatus status = BookingStatus.PENDING;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private Set<BookingItem> bookingItems;

    public Booking() {}

    public Booking(User user, BigDecimal totalAmount, BookingStatus status) {
        this.user = user;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public BookingStatus getStatus() { return status; }
    public void setStatus(BookingStatus status) { this.status = status; }
    public Set<BookingItem> getBookingItems() { return bookingItems; }
    public void setBookingItems(Set<BookingItem> bookingItems) { this.bookingItems = bookingItems; }

    public enum BookingStatus {
        PENDING,
        CONFIRMED,
        CANCELLED
    }
}
