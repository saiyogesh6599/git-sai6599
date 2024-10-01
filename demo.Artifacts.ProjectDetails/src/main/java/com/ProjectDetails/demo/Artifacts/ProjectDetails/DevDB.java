package com.ProjectDetails.demo.Artifacts.ProjectDetails;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "code.deploy", havingValue = "devDB")
public class DevDB implements DB {
	public String getData() {
		return "getting DevDB";
	}
}
