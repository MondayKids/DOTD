package com.dotd.product.controller;


import com.dotd.product.dto.ProductRegistDto;
import com.dotd.product.dto.ProductResponseDto;
import com.dotd.product.service.redis.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    private final RedisService redisService;

    // 상품 등록
    @PostMapping("/regist")
    public ResponseEntity<?> regist( ) {
        redisService.regist();
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/find")
    public ResponseEntity<?> find() {
        redisService.find();
        return ResponseEntity.ok("ok");
    }


}
