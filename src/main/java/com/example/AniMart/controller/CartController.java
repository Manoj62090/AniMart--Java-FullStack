package com.example.AniMart.controller;

import com.example.AniMart.entity.Cart;
import com.example.AniMart.entity.Toy;
import com.example.AniMart.service.CartService;
import com.example.AniMart.service.ToyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:8090") // Allow frontend requests
public class CartController {

    private final CartService cartService;
    private final ToyService toyService;

    public CartController(CartService cartService, ToyService toyService) {
        this.cartService = cartService;
        this.toyService = toyService;
    }

    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable Integer userId) {
        return cartService.getCartByUser(userId);
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestParam Integer userId, @RequestParam Integer toyId) {
        Toy toy = toyService.getToyById(toyId).orElseThrow();
        return cartService.addToCart(userId, toy);
    }

    @DeleteMapping("/remove/{id}")
    public void removeFromCart(@PathVariable Integer id) {
        cartService.removeFromCart(id);
    }
}
