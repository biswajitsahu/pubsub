package org.skylo.svc1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Svc1Application {

	public static void main(String[] args) {
		SpringApplication.run(Svc1Application.class, args);
	}

}
