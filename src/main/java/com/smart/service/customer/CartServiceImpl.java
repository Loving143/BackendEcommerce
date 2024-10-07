package com.smart.service.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.smart.dto.AddProductInCartDto;
import com.smart.entity.CartItems;
import com.smart.entity.Orders;
import com.smart.entity.Product;
import com.smart.entity.Userss;
import com.smart.enumm.OrderStatus;
import com.smart.repository.CartItemsRepository;
import com.smart.repository.OrderRepository;
import com.smart.repository.UserRepository;
import com.smart.repository.admin.product.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CartItemsRepository cartItemsRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public ResponseEntity<?> addProducts(AddProductInCartDto addProsuctInCartDto){
		Orders activeOrder = orderRepository.findByUserIdAndOrderStatus(addProsuctInCartDto.getUserId() ,OrderStatus.PENDING);
		Optional<CartItems> optionalCartItems = cartItemsRepository.findByProductIdAndOrderIdAndUserId(
									 addProsuctInCartDto.getProductId(), activeOrder.getId(), addProsuctInCartDto.getUserId());
		
		if(optionalCartItems.isPresent()) {
			System.out.println("This is the main things");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
		}
		else {
			Optional<Product> optionalProduct = productRepository.findById(addProsuctInCartDto.getProductId());
			Optional<Userss> optionalUser = userRepository.findById(addProsuctInCartDto.getUserId().longValue());
			
			if(optionalProduct.isPresent() && optionalUser.isPresent()) {
				CartItems cart = new CartItems();
				cart.setProduct(optionalProduct.get());
				cart.setPrice(optionalProduct.get().getPrice());
				cart.setOrder(activeOrder);
				cart.setQuantity(10);
				cart.setUser(optionalUser.get());
				
				CartItems updatedCart = cartItemsRepository.save(cart);
				
				activeOrder.setTotalAmount(activeOrder.getTotalAmount() + cart.getPrice());
				activeOrder.setAmount(activeOrder.getAmount()+ cart.getPrice());
				activeOrder.getCartItems().add(cart);
				
				
				orderRepository.save(activeOrder);
				
				return ResponseEntity.status(HttpStatus.CREATED).body(cart);
				
			}else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User or product not found");
			}
		}
		
	}
}
