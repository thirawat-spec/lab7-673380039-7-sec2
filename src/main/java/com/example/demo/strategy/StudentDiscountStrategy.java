package com.example.demo.strategy;
import org.springframework.stereotype.Component;

@Component
public class StudentDiscountStrategy implements DiscountStrategy {
    @Override
    public boolean supports(String type) { return "STUDENT".equals(type); }
    @Override
    public double calculateFinalPrice(double originalPrice) { return originalPrice * 0.90; } // ลด 10%
    @Override
    public String getStrategyName() { return "ส่วนลดนักศึกษา (10%)"; }
}