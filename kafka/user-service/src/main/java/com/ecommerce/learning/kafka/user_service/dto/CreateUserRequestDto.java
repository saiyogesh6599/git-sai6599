package com.ecommerce.learning.kafka.user_service.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@RequiredArgsConstructor
public class CreateUserRequestDto {

	@Id
	private Long id;
	
	@Column (name = "full_name")
	private String fullName;
	private String email;

}
