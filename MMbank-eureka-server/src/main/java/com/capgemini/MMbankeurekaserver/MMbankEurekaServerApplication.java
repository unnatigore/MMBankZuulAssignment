package com.capgemini.MMbankeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MMbankEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MMbankEurekaServerApplication.class, args);
	}

}

