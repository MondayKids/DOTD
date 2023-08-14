package com.dotd.order.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequestDTO {

    // 썸네일 이미지
    private String thumbnailImageUrl;

    // 상품 아이디
    private List<Long> productIds;

    // 주문 총 금액
    private Long totalAmount;
}
