package com.example.AniMart.controller;

import com.example.AniMart.entity.Toy;
import com.example.AniMart.service.ToyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ToyService toyService;

    public AdminController(ToyService toyService) {
        this.toyService = toyService;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/admin-dashboard";
    }

    @GetMapping("/add-toy")
    public String addToyForm(Model model) {
        model.addAttribute("toy", new Toy());
        return "admin/add-toy";
    }

    @PostMapping("/add-toy")
    public String addToy(@ModelAttribute Toy toy) {
        toyService.saveToy(toy);
        return "redirect:/toys";
    }

    @GetMapping("/edit-toy/{id}")
    public String editToyForm(@PathVariable Integer id, Model model) {
        Toy toy = toyService.getToyById(id).orElse(null);
        model.addAttribute("toy", toy);
        return "admin/edit-toy";
    }

    @PostMapping("/edit-toy")
    public String editToy(@ModelAttribute Toy toy) {
        toyService.saveToy(toy);
        return "redirect:/toys";
    }
}