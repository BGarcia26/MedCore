package com.MedCore.msmermas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients
public class MsmermasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsmermasApplication.class, args);
	}

}
