package com.example.AniMart.service;

import com.example.AniMart.entity.Cart;
import com.example.AniMart.entity.Toy;
import com.example.AniMart.repository.CartRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getCartByUser(Integer userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart addToCart(Integer userId, Toy toy) {
        Cart cart = new Cart(userId, toy);
        return cartRepository.save(cart);
    }

    public void removeFromCart(Integer id) {
        cartRepository.deleteById(id);
    }
}
