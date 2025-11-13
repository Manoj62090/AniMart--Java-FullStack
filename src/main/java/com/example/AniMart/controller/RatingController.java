package com.example.AniMart.controller;

import com.example.AniMart.entity.Rating;
import com.example.AniMart.entity.User;
import com.example.AniMart.service.RatingService;
import com.example.AniMart.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;
    private final UserService userService;

    public RatingController(RatingService ratingService, UserService userService) {
        this.ratingService = ratingService;
        this.userService = userService;
    }

    @GetMapping("/toy/{toyId}")
    public String ratingsForToy(@PathVariable Integer toyId, Model model) {
        model.addAttribute("ratings", ratingService.getRatingsByToyId(toyId));
        return "rating";
    }

    @PostMapping("/add")
    public String addRating(@ModelAttribute Rating rating, Authentication authentication) {
        if (authentication != null) {
            User user = userService.findByEmail(authentication.getName()).orElse(null);
            if (user != null) {
                rating.setUser(user);
                ratingService.saveRating(rating);
            }
        }
        return "redirect:/ratings/toy/" + rating.getToy().getId();
    }
}
