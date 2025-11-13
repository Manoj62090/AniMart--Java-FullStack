package com.example.AniMart.repository;

import com.example.AniMart.entity.Toy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ToyRepository extends JpaRepository<Toy, Integer> {

    // 🔍 This is where this method belongs
    List<Toy> findByNameContainingIgnoreCase(String name);
}
