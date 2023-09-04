package com.dotd.product.service.product;

import com.dotd.product.dto.ProductRegistDto;
import com.dotd.product.dto.ProductResponseDto;

public interface ProductService {

    // 상품 등록
    public ProductResponseDto regist(ProductRegistDto dto);

    // 상품 조회
    public ProductResponseDto findById(Integer id);




}
