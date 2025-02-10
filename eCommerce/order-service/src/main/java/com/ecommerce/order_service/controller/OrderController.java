package com.ecommerce.order_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order_service.clients.InventoryOpenFeignClient;
import com.ecommerce.order_service.dto.OrderRequestDto;
import com.ecommerce.order_service.service.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
@Slf4j
@Getter
@Setter
public class OrderController {

	private final OrderService orderService;
	private final InventoryOpenFeignClient inventoryOpenFeignClient;

	@GetMapping("/helloOrders")
	public String helloOrders() {
		return "Hello from Orders Service";
	}

//	@PostMapping("/create-order")
//	public ResponseEntity<OrderRequestDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
//		OrderRequestDto orderRequestDto1 = orderService.createOrder(orderRequestDto);
//		return ResponseEntity.ok(orderRequestDto1);
//	}

	@GetMapping
	public ResponseEntity<List<OrderRequestDto>> getAllOrders(HttpServletRequest httpServletRequest) {
		log.info("Fetching all orders via controller");
		List<OrderRequestDto> orders = orderService.getAllOrders();
		return ResponseEntity.ok(orders); // Returns 200 OK with the list of orders
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrderRequestDto> getOrderById(@PathVariable Long id) {
		log.info("Fetching order with ID: {} via controller", id);
		OrderRequestDto order = orderService.getOrderById(id);
		return ResponseEntity.ok(order); // Returns 200 OK with the order
	}
	@PostMapping("/create-order")
	public ResponseEntity<OrderRequestDto> createOrder(@RequestBody OrderRequestDto orderRequestDto){
		log.info("Inside create order:{}",orderRequestDto);
		OrderRequestDto orderRequestDto2= orderService.createOrder(orderRequestDto);
		return ResponseEntity.ok(orderRequestDto2);
		
	}
}
