package com.dotd.order.data.dto;

import com.dotd.order.data.entity.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderCreateResponseDTO {

    private Long id;

    private OrderStatus status;

    private LocalDateTime createdAt;
}
