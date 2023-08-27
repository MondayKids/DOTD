package com.dotd.order.service.impl;

import com.dotd.order.common.exception.CustomException;
import com.dotd.order.data.dto.OrderCreateRequestDTO;
import com.dotd.order.data.dto.OrderCreateResponseDTO;
import com.dotd.order.data.dto.OrderInfoResponseDTO;
import com.dotd.order.data.entity.Order;
import com.dotd.order.data.entity.OrderStatus;
import com.dotd.order.data.repository.OrderRepository;
import com.dotd.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    /**
     * 주문 생성
     */
    @Transactional
    @Override
    public OrderCreateResponseDTO createOrder(OrderCreateRequestDTO orderCreateRequestDTO) {

        Order order = Order.builder()
                .thumbnailImageUrl(orderCreateRequestDTO.getThumbnailImageUrl())
                .productIds(orderCreateRequestDTO.getProductIds())
                .totalAmount(orderCreateRequestDTO.getTotalAmount())
                .status(OrderStatus.ORDERED)
                .build();

        orderRepository.save(order);

        OrderCreateResponseDTO result = new OrderCreateResponseDTO();
        result.setId(order.getId());
        result.setStatus(order.getStatus());
        result.setCreatedAt(order.getCreatedAt());
        return result;
    }

    /**
     * 주문 정보 조회
     */
    @Override
    public OrderInfoResponseDTO findOrderById(long id) throws CustomException {
        Order order = orderRepository.findById(id).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "주문 정보 없음"));

        OrderInfoResponseDTO orderInfoResponseDTO = OrderInfoResponseDTO.builder()
                .id(order.getId())
                .status(order.getStatus())
                .totalAmount(order.getTotalAmount())
                .thumbnailImageUrl(order.getThumbnailImageUrl())
                .createdAt(order.getCreatedAt())
                .productIds(order.getProductIds())
                .build();

        return orderInfoResponseDTO;
    }

    /**
     * 주문 취소
     */
    @Transactional
    @Override
    public OrderInfoResponseDTO modifyOrderById(long id) throws CustomException {
        Order order = orderRepository.findById(id).orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "주문 정보 없음"));

        order.setStatus(OrderStatus.CANCELLED);

        OrderInfoResponseDTO orderInfoResponseDTO = OrderInfoResponseDTO.builder()
                .id(order.getId())
                .status(order.getStatus())
                .totalAmount(order.getTotalAmount())
                .thumbnailImageUrl(order.getThumbnailImageUrl())
                .createdAt(order.getCreatedAt())
                .productIds(order.getProductIds())
                .build();

        return orderInfoResponseDTO;
    }
}
