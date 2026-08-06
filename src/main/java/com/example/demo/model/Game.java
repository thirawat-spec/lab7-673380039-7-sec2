package com.example.demo.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private String platform;
    private Double rating;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    
    private Double price;
    private String discountType; // "NONE", "STUDENT", "SEASONAL"

    // ฟิลด์เหล่านี้ใช้แสดงผลบนหน้าเว็บเท่านั้น (ไม่บันทึกลง DB)
    @Transient
    private Double finalPrice;
    
    @Transient
    private String discountName;

    // --- Constructor ---
    public Game() {}

    // --- Getters & Setters ---
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }
    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDate releaseDate) { this.releaseDate = releaseDate; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getDiscountType() { return discountType; }
    public void setDiscountType(String discountType) { this.discountType = discountType; }
    public Double getFinalPrice() { return finalPrice; }
    public void setFinalPrice(Double finalPrice) { this.finalPrice = finalPrice; }
    public String getDiscountName() { return discountName; }
    public void setDiscountName(String discountName) { this.discountName = discountName; }
}