package com.example.AniMart.repository;

import com.example.AniMart.entity.AnimeCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<AnimeCharacter, Integer> {}
