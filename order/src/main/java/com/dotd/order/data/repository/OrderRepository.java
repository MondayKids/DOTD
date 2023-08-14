package com.dotd.order.data.repository;

import com.dotd.order.data.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
