package com.example.AniMart.controller;

import com.example.AniMart.entity.Toy;
import com.example.AniMart.entity.Booking;
import com.example.AniMart.entity.Rating;
import com.example.AniMart.service.ToyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/toys")
public class ToyController {

    private final ToyService toyService;

    public ToyController(ToyService toyService) {
        this.toyService = toyService;
    }

    // ✅ List all toys — loads toys.html (glassmorphic toy grid)
    @GetMapping
    public String listToys(Model model) {
        model.addAttribute("toys", toyService.getAllToys());
        return "toys";
    }

    // ✅ View details of a single toy — loads toy-details.html
    @GetMapping("/{id}")
    public String toyDetails(@PathVariable Integer id, Model model) {
        Toy toy = toyService.getToyById(id).orElse(null);
        model.addAttribute("toy", toy);
        model.addAttribute("booking", new Booking());
        model.addAttribute("rating", new Rating());
        return "toy-details";
    }
}
