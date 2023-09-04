package com.dotd.product.service.product;


import com.dotd.product.dto.ProductRegistDto;
import com.dotd.product.dto.ProductResponseDto;
import com.dotd.product.entity.Product;
import com.dotd.product.mapper.ProductMapper;
import com.dotd.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;




    // 상품 등록
    @Override
    public ProductResponseDto regist(ProductRegistDto dto) {
        Product product = productMapper.productRegistDtoToProduct(dto);
        Product save = productRepository.save(product);
        return productMapper.productToProductResponseDto(save);

    }

    // 상품 상세 조회
    @Override
    public ProductResponseDto findById(Integer id) {
        Product product = productRepository.findById(id).get();
        return productMapper.productToProductResponseDto(product);
    }
}
