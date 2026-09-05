package com.example.boilerplate.domain.auth.repository;

import com.example.boilerplate.domain.auth.entity.RefreshToken;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

  Optional<RefreshToken> findByTokenHash(String tokenHash);

  void deleteByUserId(Long userId);

  void deleteByExpiresAtBefore(LocalDateTime now);
}
