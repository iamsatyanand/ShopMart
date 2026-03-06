package com.satyanand.shopmart.security.repository;

import com.satyanand.shopmart.security.model.RefreshToken;
import com.satyanand.shopmart.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByToken(String token);

    void deleteByUser(User user);
}
