package com.ISN3Java.ISN3Java;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@OpenAPIDefinition(
		info = @Info(
				title = "ISN3 Java Application API",
				version = "1.0",
				description = "API documentation for ISN3 Java Application"
		)
)

public class Isn3JavaApplication {


	public static void main(String[] args) {
		SpringApplication.run(Isn3JavaApplication.class, args);
	}

}
