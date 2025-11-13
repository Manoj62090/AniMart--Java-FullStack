package com.example.AniMart.controller;

import com.example.AniMart.entity.Wishlist;
import com.example.AniMart.entity.Toy;
import com.example.AniMart.service.WishlistService;
import com.example.AniMart.service.ToyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
@CrossOrigin(origins = "http://localhost:8090")
public class WishlistController {

    private final WishlistService wishlistService;
    private final ToyService toyService;

    public WishlistController(WishlistService wishlistService, ToyService toyService) {
        this.wishlistService = wishlistService;
        this.toyService = toyService;
    }

    @GetMapping("/{userId}")
    public List<Wishlist> getWishlist(@PathVariable Integer userId) {
        return wishlistService.getWishlistByUser(userId);
    }

    @PostMapping("/add")
    public Wishlist addToWishlist(@RequestParam Integer userId, @RequestParam Integer toyId) {
        Toy toy = toyService.getToyById(toyId).orElseThrow();
        return wishlistService.addToWishlist(userId, toy);
    }

    @DeleteMapping("/remove/{id}")
    public void removeFromWishlist(@PathVariable Integer id) {
        wishlistService.removeFromWishlist(id);
    }
}
