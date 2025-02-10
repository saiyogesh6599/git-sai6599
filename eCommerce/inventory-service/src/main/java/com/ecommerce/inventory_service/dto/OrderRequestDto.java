package com.ecommerce.inventory_service.dto;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class OrderRequestDto {
    private List<OrderRequestItemDto> items;
}
