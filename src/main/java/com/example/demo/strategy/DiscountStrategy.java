package com.example.demo.strategy;

public interface DiscountStrategy {
    boolean supports(String type); // เช็คว่า Strategy นี้ใช้กับ type ไหน
    double calculateFinalPrice(double originalPrice);
    String getStrategyName();
}