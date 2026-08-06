package com.example.demo.strategy;
import org.springframework.stereotype.Component;

@Component
public class SeasonalSaleStrategy implements DiscountStrategy {
    @Override
    public boolean supports(String type) { return "SEASONAL".equals(type); }
    @Override
    public double calculateFinalPrice(double originalPrice) { return originalPrice * 0.80; } // ลด 20%
    @Override
    public String getStrategyName() { return "ส่วนลดเทศกาล (20%)"; }
}