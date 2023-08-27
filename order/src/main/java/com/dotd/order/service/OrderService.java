package com.dotd.order.service;

import com.dotd.order.common.exception.CustomException;
import com.dotd.order.data.dto.OrderCreateRequestDTO;
import com.dotd.order.data.dto.OrderCreateResponseDTO;
import com.dotd.order.data.dto.OrderInfoResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    OrderCreateResponseDTO createOrder(OrderCreateRequestDTO orderCreateRequestDTO);

    OrderInfoResponseDTO findOrderById(long id) throws CustomException;

    OrderInfoResponseDTO modifyOrderById(long id) throws CustomException;
}
