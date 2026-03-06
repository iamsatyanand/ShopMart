package com.satyanand.shopmart.security.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

public class JwtService {

    @Value("${security.jwt.secret}")
    private String jwtSecret;

    @Value("${security.jwt.expiration}")
    private long jwtExpiration;

    private SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String email, String role){
        return Jwts.builder()
                .subject(email)
                .claim("role", role)
                .signWith(getSecretKey())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(Date.from(Instant.now().plusMillis(jwtExpiration)))
                .compact();
    }
}
