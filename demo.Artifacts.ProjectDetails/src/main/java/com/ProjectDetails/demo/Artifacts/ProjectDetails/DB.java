package com.ProjectDetails.demo.Artifacts.ProjectDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public interface DB {

	@Autowired
	String getData();
	
}
