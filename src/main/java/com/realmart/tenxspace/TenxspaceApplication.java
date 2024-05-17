package com.realmart.tenxspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TenxspaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenxspaceApplication.class, args);
	}

}
