package com.dotd.order.service;

import com.dotd.order.data.dto.OrderCreateRequestDTO;
import com.dotd.order.data.dto.OrderCreateResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    OrderCreateResponseDTO createOrder(OrderCreateRequestDTO orderCreateRequestDTO);
}
