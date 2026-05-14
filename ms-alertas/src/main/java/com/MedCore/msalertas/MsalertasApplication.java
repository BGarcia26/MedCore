package com.MedCore.msalertas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsalertasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsalertasApplication.class, args);
	}

}
