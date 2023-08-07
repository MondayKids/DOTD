package com.dotd.order.controller;

import com.dotd.order.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthCheckController {

    private final OrderServiceImpl orderService;
    @GetMapping("/health")
    public String healthCheck() {
        return "ok";
    }
}
