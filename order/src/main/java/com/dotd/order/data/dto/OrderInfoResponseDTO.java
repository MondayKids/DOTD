package com.dotd.order.data.dto;

import com.dotd.order.data.entity.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class OrderInfoResponseDTO {
    private long id;
    private OrderStatus status;
    private long totalAmount;
    private String thumbnailImageUrl;
    private LocalDateTime createdAt;
    private List<Long> productIds;
}
