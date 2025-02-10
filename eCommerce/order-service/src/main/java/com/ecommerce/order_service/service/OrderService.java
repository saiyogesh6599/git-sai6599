package com.ecommerce.order_service.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.ecommerce.order_service.clients.InventoryOpenFeignClient;
import com.ecommerce.order_service.dto.OrderRequestDto;
import com.ecommerce.order_service.entity.OrderItem;
import com.ecommerce.order_service.entity.OrderStatus;
import com.ecommerce.order_service.entity.Orders;
import com.ecommerce.order_service.repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

	private final OrderRepository orderRepository;
	private final ModelMapper modelMapper;
	private final InventoryOpenFeignClient inventoryOpenFeignClient;

	public List<OrderRequestDto> getAllOrders() {
		log.info("Fetching all orders");
		List<Orders> orders = orderRepository.findAll();
		return orders.stream().map(order -> modelMapper.map(order, OrderRequestDto.class)).toList();
	}

	public OrderRequestDto getOrderById(Long id) {
		log.info("Fetching order with ID: {}", id);
		Orders order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
		return modelMapper.map(order, OrderRequestDto.class);
	}

//  @Retry(name = "inventoryRetry", fallbackMethod = "createOrderFallback")
	@CircuitBreaker(name = "inventoryCircuitBreaker", fallbackMethod = "createOrderFallback")
//  @RateLimiter(name = "inventoryRateLimiter", fallbackMethod = "createOrderFallback")
	public OrderRequestDto createOrder(OrderRequestDto orderRequestDto) {
		log.info("Calling the createOrder method");
		Double totalPrice = inventoryOpenFeignClient.reduceStocks(orderRequestDto);

		Orders orders = modelMapper.map(orderRequestDto, Orders.class);
		for (OrderItem orderItem : orders.getItems()) {
			orderItem.setOrder(orders);
		}
		orders.setTotalPrice(totalPrice);
		orders.setOrderStatus(OrderStatus.CONFIRMED);

		Orders savedOrder = orderRepository.save(orders);

		return modelMapper.map(savedOrder, OrderRequestDto.class);
	}

}
