package com.example.demo.repository;

import com.example.demo.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    // สืบทอด CRUD พื้นฐานมาทั้งหมด ไม่ต้องเขียน SQL เอง (Information Expert)
}