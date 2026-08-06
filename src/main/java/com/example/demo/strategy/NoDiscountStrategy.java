package com.example.demo.strategy;
import org.springframework.stereotype.Component;

@Component
public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public boolean supports(String type) { return "NONE".equals(type); }
    @Override
    public double calculateFinalPrice(double originalPrice) { return originalPrice; }
    @Override
    public String getStrategyName() { return "ราคาปกติ (0%)"; }
}