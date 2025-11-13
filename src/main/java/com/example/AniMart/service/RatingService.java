package com.example.AniMart.service;

import com.example.AniMart.entity.Rating;
import com.example.AniMart.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsByToyId(Integer toyId) {
        return ratingRepository.findByToyId(toyId);
    }

    public Optional<Rating> getRatingById(Integer id) {
        return ratingRepository.findById(id);
    }
}
