package com.example.AniMart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "anime_characters")
public class AnimeCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String animeName;
    private String description;
    private String imageUrl;

    public AnimeCharacter() {}

    public AnimeCharacter(String name, String animeName, String description, String imageUrl) {
        this.name = name;
        this.animeName = animeName;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAnimeName() { return animeName; }
    public void setAnimeName(String animeName) { this.animeName = animeName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
