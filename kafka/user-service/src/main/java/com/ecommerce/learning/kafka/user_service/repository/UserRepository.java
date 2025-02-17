package com.ecommerce.learning.kafka.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.learning.kafka.user_service.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
