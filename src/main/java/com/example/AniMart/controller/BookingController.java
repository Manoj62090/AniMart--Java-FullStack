package com.example.AniMart.controller;

import com.example.AniMart.entity.Booking;
import com.example.AniMart.entity.User;
import com.example.AniMart.service.BookingService;
import com.example.AniMart.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;

    public BookingController(BookingService bookingService, UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @GetMapping
    public String listBookings(Model model, Authentication authentication) {
        if (authentication != null) {
            User user = userService.findByEmail(authentication.getName()).orElse(null);
            if (user != null) {
                model.addAttribute("bookings", bookingService.getAllBookings()
                        .stream()
                        .filter(b -> b.getUser().getId().equals(user.getId()))
                        .toList());
            }
        }
        return "booking";
    }

    @PostMapping("/add")
    public String addBooking(@ModelAttribute Booking booking, Authentication authentication) {
        if (authentication != null) {
            User user = userService.findByEmail(authentication.getName()).orElse(null);
            if (user != null) {
                booking.setUser(user);
                bookingService.saveBooking(booking);
            }
        }
        return "redirect:/bookings";
    }
}
