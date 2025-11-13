package com.example.AniMart.controller;

import com.example.AniMart.service.ToyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    private final ToyService toyService;

    public ShopController(ToyService toyService) {
        this.toyService = toyService;
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("toys", toyService.getAllToys());
        return "shop";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        return "cart";
    }

    @GetMapping("/collection")
    public String collection(Model model) {
        return "collection";
    }
}
