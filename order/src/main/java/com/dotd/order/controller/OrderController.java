package com.dotd.order.controller;

import com.dotd.order.common.exception.CustomException;
import com.dotd.order.data.dto.OrderCreateRequestDTO;
import com.dotd.order.data.dto.OrderCreateResponseDTO;
import com.dotd.order.data.dto.OrderInfoResponseDTO;
import com.dotd.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    /**
     * 주문 생성
     */
    @PostMapping
    public ResponseEntity<OrderCreateResponseDTO> createOrder(@RequestBody(required = false) OrderCreateRequestDTO requestDTO) throws CustomException {
        if (requestDTO == null) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Request body is missing");
        }

        OrderCreateResponseDTO responseDTO = orderService.createOrder(requestDTO);
        return ResponseEntity.ok(responseDTO);
    }

    /**
     * 주문 조회
     */
    @GetMapping("/{id}")
    public ResponseEntity<OrderInfoResponseDTO> getOrderInfo(@PathVariable(value = "id", required = false) Long id) throws CustomException {
        if (id == null) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Param is missing");
        }

        OrderInfoResponseDTO orderInfoResponseDTO = orderService.findOrderById(id);

        return ResponseEntity.ok(orderInfoResponseDTO);
    }
}
