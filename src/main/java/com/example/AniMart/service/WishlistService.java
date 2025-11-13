package com.example.AniMart.service;

import com.example.AniMart.entity.Wishlist;
import com.example.AniMart.entity.Toy;
import com.example.AniMart.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<Wishlist> getWishlistByUser(Integer userId) {
        return wishlistRepository.findByUserId(userId);
    }

    public Wishlist addToWishlist(Integer userId, Toy toy) {
        Wishlist wishlist = new Wishlist(userId, toy);
        return wishlistRepository.save(wishlist);
    }

    public void removeFromWishlist(Integer id) {
        wishlistRepository.deleteById(id);
    }
}
