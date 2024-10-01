package com.ProjectDetails.demo.Artifacts.ProjectDetails;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Apple {

	public void AppleNew() {
		System.out.println("sai");
	}

	@PostConstruct
	void callThisBeforeAppleIsCreated() {
		System.out.println("before sai");
	}

	@PreDestroy
	void callThisAfterAppleIsExecuted() {
		System.out.println("destroying after execution");
	}
}
