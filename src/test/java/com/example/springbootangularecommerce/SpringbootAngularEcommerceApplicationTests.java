package com.example.springbootangularecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringbootAngularEcommerceApplicationTests {
    @Autowired
    RedisTemplate redisTemplate;




}
