package com.MedCore.msmovimientos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsmovimientosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsmovimientosApplication.class, args);
	}

}
