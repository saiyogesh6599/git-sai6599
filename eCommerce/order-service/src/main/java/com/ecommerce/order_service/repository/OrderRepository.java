package com.ecommerce.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.order_service.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{

}
