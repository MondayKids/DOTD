package com.dotd.product.controller;


import com.dotd.product.dto.ProductRegistDto;
import com.dotd.product.dto.ProductResponseDto;
import com.dotd.product.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
@Slf4j
public class ProductController {

    private final ProductService productService;

    // 상품 등록
    @PostMapping("/regist")
    public ResponseEntity<?> regist(@RequestBody ProductRegistDto dto) {
        ProductResponseDto result = productService.regist(dto);
        return ResponseEntity.ok(result);
    }

    // 상품 조회
    @GetMapping("/findById")
    public ResponseEntity<?> findById(@RequestParam(name = "id") Integer id) {
        ProductResponseDto result = productService.findById(id);
        return ResponseEntity.ok(result);
    }

}
