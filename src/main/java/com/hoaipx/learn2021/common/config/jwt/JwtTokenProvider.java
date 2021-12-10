package com.hoaipx.learn2021.common.config.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class JwtTokenProvider {

    @Value("${config.jwtSecret}")
    private String jwtSecret;

    @Value("${config.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${config.jwtRefreshExpirationMs}")
    private int jwtRefreshExpirationMs;

    public String createFreshToken(String username) {
        return null;
    }

    public String refreshToken(String token) {
        if(!validateJwtToken(token)) {
            String username = getUserNameFromJwtToken(token);
            return username;
        }
        return token;
    }

    public String generateJwtToken(Authentication authentication) {
        return generateTokenFromUsername(((org.springframework.security.core.userdetails.User)authentication.getPrincipal()).getUsername());
    }

    public String generateTokenFromUsername(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes())
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret.getBytes())
                .parseClaimsJws(token.replace("Bearer",""))
                .getBody()
                .getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecret.getBytes())
                    .parseClaimsJws(authToken.replace("Bearer",""));
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            log.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

}
