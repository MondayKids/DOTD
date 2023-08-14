package com.dotd.order.controller;

import com.dotd.order.common.exception.CustomException;
import com.dotd.order.data.dto.OrderCreateRequestDTO;
import com.dotd.order.data.dto.OrderCreateResponseDTO;
import com.dotd.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderCreateResponseDTO> createOrder(@RequestBody(required = false) OrderCreateRequestDTO requestDTO) throws CustomException {
        if (requestDTO == null) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Request body is missing");
        }

        OrderCreateResponseDTO responseDTO = orderService.createOrder(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }
}
