package com.ecommerce.inventory_service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class OrderRequestItemDto {
	
	private Long productId;
	private Integer quantity;
}
