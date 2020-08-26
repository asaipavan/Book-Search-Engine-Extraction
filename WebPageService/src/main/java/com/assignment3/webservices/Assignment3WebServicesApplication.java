package com.assignment3.webservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//(scanBasePackages = {"com.assignment3.webservices","com.assignment3.catalogue","com.assignment3.searchlog","com.assignment3.usernotes"})
@Configuration
public class Assignment3WebServicesApplication extends SpringBootServletInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Assignment3WebServicesApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Assignment3WebServicesApplication.class, args);
	}

}
