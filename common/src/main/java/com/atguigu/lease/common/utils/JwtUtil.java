package com.atguigu.lease.common.utils;

import com.atguigu.lease.common.exception.LeaseException;
import com.atguigu.lease.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {
    // Build secretKey
    private final static SecretKey secretKey = Keys.hmacShaKeyFor("craiiiigcraiiiigcraiiiigcraiiiig".getBytes());

    public static String createToken(Long userId, String username) {

        String jwt = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2)) // time unit: ms
                .setSubject("LOGIN_USER")
                .claim("userId", userId)
                .claim("username", username)
                // Signature
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

        return jwt;
    }

    public static void parseToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts
                    .parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);

        } catch (ExpiredJwtException e) {
            throw new LeaseException(ResultCodeEnum.TOKEN_EXPIRED);
        } catch (JwtException e) {
            //  Unified handling of all other exceptions
            throw new LeaseException(ResultCodeEnum.TOKEN_INVALID);
        }

    }

//    public static void main(String[] args) {
//        System.out.println(createToken(1L, "admin"));
//    }
}
