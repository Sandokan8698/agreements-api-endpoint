package com.damg.agreementsapiendpoints.agreementsapiendpoints;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.damg.agreementsapiendpoints")
public class AgreementsApiEndpointsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgreementsApiEndpointsApplication.class, args);
	}
}
