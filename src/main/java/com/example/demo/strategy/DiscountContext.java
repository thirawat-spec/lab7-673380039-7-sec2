package com.example.demo.strategy;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DiscountContext {
    private final List<DiscountStrategy> strategies;

    // Constructor Injection ตามกฎโจทย์
    public DiscountContext(List<DiscountStrategy> strategies) {
        this.strategies = strategies;
    }

    public DiscountStrategy getStrategy(String discountType) {
        return strategies.stream()
                .filter(strategy -> strategy.supports(discountType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("ไม่พบรูปแบบส่วนลด: " + discountType));
    }
}