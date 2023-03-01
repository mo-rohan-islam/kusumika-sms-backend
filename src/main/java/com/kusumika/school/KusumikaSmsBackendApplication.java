package com.kusumika.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = "classpath:properties/application-${spring.profiles.active}.properties")
public class KusumikaSmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(KusumikaSmsBackendApplication.class, args);
	}

}
