package com.ProjectDetails.demo.Artifacts.ProjectDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
	
	@SpringBootApplication
	public class Application implements CommandLineRunner{
		
//		@Autowired
//		Apple obj;
//		
//		@Autowired
//		Apple obj1;
		
		@Autowired
		DBService dbservice;
		
		 public static void main(String[] args) {
	        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
	        Runtime.getRuntime().addShutdownHook(new Thread(context::close));
	    }
		@Override
		public void run(String... args) throws Exception {
			
			dbservice.getData();
		}
//			obj.AppleNew();
//			obj1.AppleNew();
//			
//			System.out.println(obj.hashCode());
//			System.out.println(obj.hashCode());
//		}
		
	
	}
