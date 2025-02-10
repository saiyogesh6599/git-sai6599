package com.ecommerce.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.order_service.config.FeaturesEnableConfig;
import com.ecommerce.order_service.dto.OrderRequestDto;
import com.ecommerce.order_service.service.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
@Slf4j
@RefreshScope
public class OrderController {

	private final OrderService orderService;

	@Value("${my.variable}")
	private String myVariable;

	private final FeaturesEnableConfig featuresEnableConfig;

	@GetMapping("/helloOrders")
	public String helloOrders() {

		if (featuresEnableConfig.isUserTrackingEnabled()) {
			return "User tracking enabled wohoo, my variable is: " + myVariable;
		} else {
			return "User tracking disabled awww, my variable is: " + myVariable;
		}
	}

	@PostMapping("/create-order")
	public ResponseEntity<OrderRequestDto> createOrder(@RequestBody OrderRequestDto orderRequestDto) {
		OrderRequestDto orderRequestDto1 = orderService.createOrder(orderRequestDto);
		return ResponseEntity.ok(orderRequestDto1);
	}

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
}
