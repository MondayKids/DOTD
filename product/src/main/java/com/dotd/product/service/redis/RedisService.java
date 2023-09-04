package com.dotd.product.service.redis;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    public void regist() {
        redisTemplate.opsForValue().set("testKey", "testContent");
    }

    public void find() {
        Object testKey = redisTemplate.opsForValue().get("testKey");
        System.out.println(testKey);
    }



}
