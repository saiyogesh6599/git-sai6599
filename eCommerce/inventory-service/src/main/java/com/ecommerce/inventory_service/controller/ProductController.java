package com.ecommerce.inventory_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import com.ecommerce.inventory_service.clients.OrdersFiegnCleint;
import com.ecommerce.inventory_service.dto.OrderRequestDto;
import com.ecommerce.inventory_service.dto.ProductDto;
import com.ecommerce.inventory_service.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
@Getter
@Setter
public class ProductController {

	private final ProductService productService;
	private final RestClient restClient;
	private final OrdersFiegnCleint ordersFiegnCleint;

	@GetMapping("/fetchOrders")
	public String fetchFromOrdersService(HttpServletRequest httpServletRequest) {

		log.info(httpServletRequest.getHeader("x-custom-header"));

//		List<ServiceInstance> instances = discoveryClient.getInstances("order-service");

//		if (instances.isEmpty()) {
//			throw new RuntimeException("No instances found for order-service");
//		}
//
//		ServiceInstance orderService = instances.get(0);
//		String orderServiceUrl = orderService.getUri().toString() + "/orders/core/helloOrders";
//
//		log.info("Calling ORDER-SERVICE at: {}", orderServiceUrl);
//
//		return restClient.get().uri(orderServiceUrl).retrieve().body(String.class);

		return ordersFiegnCleint.helloOrders();
	}

	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllInventory() {
		List<ProductDto> inventories = productService.getAllInventory();
		return ResponseEntity.ok(inventories);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getInventoryById(@PathVariable Long id) {
		ProductDto inventory = productService.getProductById(id);
		return ResponseEntity.ok(inventory);
	}

	@PutMapping("reduce-stocks")
	public ResponseEntity<Double> reduceStocks(@RequestBody OrderRequestDto orderRequestDto) {
		Double totalPrice = productService.reduceStocks(orderRequestDto);
		return ResponseEntity.ok(totalPrice);
	}
}
