package com.example.AniMart.service;

import com.example.AniMart.entity.Toy;
import com.example.AniMart.repository.ToyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToyService {

    private final ToyRepository toyRepository;

    public ToyService(ToyRepository toyRepository) {
        this.toyRepository = toyRepository;
    }

    public List<Toy> getAllToys() {
        return toyRepository.findAll();
    }

    public Optional<Toy> getToyById(Integer id) {
        return toyRepository.findById(id);
    }

    // ✅ This uses the repository method above
    public List<Toy> searchToys(String keyword) {
        return toyRepository.findByNameContainingIgnoreCase(keyword);
    }

    public void saveToy(Toy toy) {
        toyRepository.save(toy);
    }
}
