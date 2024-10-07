package com.smart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smart.entity.CartItems;

public interface CartItemsRepository extends JpaRepository<CartItems, Integer>{

	Optional<CartItems> findByProductIdAndOrderIdAndUserId(Integer productId, Integer orderId,
			Integer userId);

}
