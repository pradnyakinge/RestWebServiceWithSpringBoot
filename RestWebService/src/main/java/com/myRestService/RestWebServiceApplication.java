package com.myRestService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan("com.myRestService.*")
@SpringBootApplication
public class RestWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWebServiceApplication.class, args);
	}

}
