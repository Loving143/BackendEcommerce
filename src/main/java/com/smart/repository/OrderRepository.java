package com.smart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.Orders;
import com.smart.enumm.OrderStatus;

public interface OrderRepository extends JpaRepository<Orders,Integer>{

	Orders findByUserIdAndOrderStatus(Integer userId, OrderStatus pending);

}
