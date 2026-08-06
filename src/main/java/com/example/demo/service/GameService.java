package com.example.demo.service;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;
import com.example.demo.strategy.DiscountContext;
import com.example.demo.strategy.DiscountStrategy;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final DiscountContext discountContext;

    // Constructor Injection (DIP: พึ่งพา Abstraction)
    public GameService(GameRepository gameRepository, DiscountContext discountContext) {
        this.gameRepository = gameRepository;
        this.discountContext = discountContext;
    }

    public List<Game> getAllGames() {
        List<Game> games = gameRepository.findAll();
        // คำนวณราคาและชื่อโปรโมชั่นก่อนส่งไป View
        return games.stream().map(this::applyDiscountData).collect(Collectors.toList());
    }

    public Game getGameById(Long id) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid game Id:" + id));
        return applyDiscountData(game);
    }

    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }

    // ฟังก์ชันช่วยเหลือสำหรับคำนวณราคาสุทธิโดยเรียกใช้ Strategy Pattern
    private Game applyDiscountData(Game game) {
        if (game.getDiscountType() != null) {
            DiscountStrategy strategy = discountContext.getStrategy(game.getDiscountType());
            game.setFinalPrice(strategy.calculateFinalPrice(game.getPrice()));
            game.setDiscountName(strategy.getStrategyName());
        } else {
            game.setFinalPrice(game.getPrice());
            game.setDiscountName("ไม่มีส่วนลด");
        }
        return game;
    }
}