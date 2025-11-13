package com.example.AniMart.repository;

import com.example.AniMart.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByToyId(Integer toyId);
}
