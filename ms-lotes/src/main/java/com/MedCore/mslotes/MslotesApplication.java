package com.MedCore.mslotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MslotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MslotesApplication.class, args);
	}

}
