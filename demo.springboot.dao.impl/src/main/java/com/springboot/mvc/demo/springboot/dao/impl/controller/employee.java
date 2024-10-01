package com.springboot.mvc.demo.springboot.dao.impl.controller;

import java.time.LocalDate;

 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mvc.demo.springboot.dao.impl.dto.employeeDTO;


@RestController
@RequestMapping(path ="/employees")
public class employee {

	@GetMapping("/employees/{employeeId}")
    public employeeDTO getEmployeeById(@PathVariable long employeeId) {
        return new employeeDTO(employeeId, "sai", "sai@123", LocalDate.of(2024, 1, 9), true);	
    }
	@PostMapping
	public employeeDTO setEmployeeById(@RequestBody employeeDTO inputemployeedto) {
		inputemployeedto.setId(100L);
		return inputemployeedto;	
	}
	
	@GetMapping("/test")
	public String testEndpoint() {
	    return "Hello, World!";
	}
}
