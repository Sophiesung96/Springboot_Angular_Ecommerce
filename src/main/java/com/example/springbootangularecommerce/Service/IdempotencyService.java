package com.example.springbootangularecommerce.Service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class IdempotencyService {

    private final RedisTemplate<String, Object> redisTemplate;

    public IdempotencyService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean isDuplicateRequest(String key) {
        return Boolean.TRUE.equals(redisTemplate.hasKey(key));
    }

    public <T> void storeResponse(String key, T response) {

        redisTemplate.opsForValue().set(key, response, 5, TimeUnit.MINUTES);
    }

    public <T> T getResponse(String key, Class<T> responseType) {

        return (T) redisTemplate.opsForValue().get(key);
    }
}
