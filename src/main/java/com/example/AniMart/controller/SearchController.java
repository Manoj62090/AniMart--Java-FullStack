package com.example.AniMart.controller;

import com.example.AniMart.entity.Toy;
import com.example.AniMart.service.ToyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {

    private final ToyService toyService;

    public SearchController(ToyService toyService) {
        this.toyService = toyService;
    }

    @GetMapping
    public String searchToys(@RequestParam("query") String query, Model model) {
        List<Toy> toys = toyService.searchToys(query);
        model.addAttribute("toys", toys);
        model.addAttribute("query", query);
        return "shop";
    }
}
