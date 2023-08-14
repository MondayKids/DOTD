package com.dotd.order.service.impl;

import com.dotd.order.data.dto.OrderCreateRequestDTO;
import com.dotd.order.data.dto.OrderCreateResponseDTO;
import com.dotd.order.data.entity.Order;
import com.dotd.order.data.entity.OrderStatus;
import com.dotd.order.data.repository.OrderRepository;
import com.dotd.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    @Override
    public OrderCreateResponseDTO createOrder(OrderCreateRequestDTO orderCreateRequestDTO) {

        Order order = Order.builder()
                .thumbnailImageUrl(orderCreateRequestDTO.getThumbnailImageUrl())
                .productIds(orderCreateRequestDTO.getProductIds())
                .totalAmount(orderCreateRequestDTO.getTotalAmount())
                .status(OrderStatus.CANCELLED)
                .build();

        orderRepository.save(order);

        OrderCreateResponseDTO result = new OrderCreateResponseDTO();
        result.setStatus(OrderStatus.CANCELLED);
        return result;
    }
}
